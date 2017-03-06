package rs.ac.uns.ftn.tseo.ctecdev.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.tseo.ctecdev.model.Obaveza;
import rs.ac.uns.ftn.tseo.ctecdev.model.Pohadja;
import rs.ac.uns.ftn.tseo.ctecdev.model.Predaje;
import rs.ac.uns.ftn.tseo.ctecdev.model.Predmet;
import rs.ac.uns.ftn.tseo.ctecdev.model.TipObaveze;
import rs.ac.uns.ftn.tseo.ctecdev.service.ObavezaService;
import rs.ac.uns.ftn.tseo.ctecdev.service.PohadjaService;
import rs.ac.uns.ftn.tseo.ctecdev.service.PredajeService;
import rs.ac.uns.ftn.tseo.ctecdev.service.PredmetService;
import rs.ac.uns.ftn.tseo.ctecdev.service.TipObavezeService;
import rs.ac.uns.ftn.tseo.ctecdev.web.dto.PohadjaDTO;
import rs.ac.uns.ftn.tseo.ctecdev.web.dto.PredajeDTO;
import rs.ac.uns.ftn.tseo.ctecdev.web.dto.PredmetDTO;
import rs.ac.uns.ftn.tseo.ctecdev.web.dto.ProfesorDTO;
import rs.ac.uns.ftn.tseo.ctecdev.web.dto.StudentDTO;
import rs.ac.uns.ftn.tseo.ctecdev.web.dto.TipObavezeDTO;

@RestController
@RequestMapping(value="api/predmeti")
public class PredmetController {
	
	@Autowired
	private PredmetService predmetService;
	@Autowired
	private PredajeService predajeService;
	@Autowired
	private PohadjaService pohadjaService;
	@Autowired
	private ObavezaService obavezaService;
	@Autowired
	private TipObavezeService tipObavezeService;
	
	//Get all
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public ResponseEntity<List<PredmetDTO>> getAllPredmeti(){
		List<Predmet> predmeti=predmetService.findAll();
		List<PredmetDTO> predmetiDTO=new ArrayList<>();
		for (Predmet predmet: predmeti) {
			predmetiDTO.add(new PredmetDTO(predmet));
		}
		return new ResponseEntity<>(predmetiDTO, HttpStatus.OK);
	}
	
	//Get page
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PredmetDTO>> getPredmetiPage(Pageable page){
		Page<Predmet> predmeti=predmetService.findAll(page);
		List<PredmetDTO> predmetiDTO=new ArrayList<>();
		for (Predmet predmet: predmeti) {
			predmetiDTO.add(new PredmetDTO(predmet));
		}
		return new ResponseEntity<>(predmetiDTO, HttpStatus.OK);
		
	}
	
	//Get one 
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<PredmetDTO> getPredmet(@PathVariable Integer id){
		Predmet predmet= predmetService.findOne(id);
		if(predmet == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new PredmetDTO(predmet), HttpStatus.OK);
	}
	
	//Create
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<PredmetDTO> savePredmet(@RequestBody PredmetDTO predmetDTO){
		Predmet p=new Predmet();
		
		p.setNaziv(predmetDTO.getNaziv());
		p.setOpis(predmetDTO.getOpis());
		
		predmetService.save(p);
	
		return new ResponseEntity<>(new PredmetDTO(p), HttpStatus.CREATED);
	}
	
	//Update
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<PredmetDTO> updatePredmet(@RequestBody PredmetDTO predmetDTO){
		
		Predmet p= predmetService.findOne(predmetDTO.getPredmetID()); 
		if (p == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		p.setNaziv(predmetDTO.getNaziv());
		p.setOpis(predmetDTO.getOpis());
		
		predmetService.save(p);
	
		return new ResponseEntity<>(new PredmetDTO(p), HttpStatus.CREATED);
	}
		
	//Delete
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletePredmet(@PathVariable Integer id){
		Predmet predmet = predmetService.findOne(id);
		if (predmet != null){
			
			//predavanja
			for (Predaje pr : predmet.getPredavanja()){
				predajeService.remove(pr.getPredajeID());
			}
			
			//pohadjanja
			for (Pohadja po : predmet.getPohadjanja()){
				pohadjaService.remove(po.getPohadjaID());
			}
			
			//tipoviObaveza i obaveze
			for (TipObaveze t : predmet.getTipoviObaveza()){
				for (Obaveza o : t.getObaveze()){
					obavezaService.remove(o.getObavezaID());
				}
				tipObavezeService.remove(t.getTipObavezeID());
			}
			
			predmetService.remove(id);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	//All students from course
	@RequestMapping(value="/{id}/studenti", method=RequestMethod.GET)
	public ResponseEntity<List<PohadjaDTO>> getPredmetStudents(@PathVariable Integer id){
		Predmet p = predmetService.findOne(id);
		Set<Pohadja> pohadjanja=p.getPohadjanja();
		List<PohadjaDTO> pohadjanjaDTO=new ArrayList<>();
		for (Pohadja pohadja : pohadjanja) {
			PohadjaDTO pohadjaDTO=new PohadjaDTO();
			pohadjaDTO.setPohadjaID(pohadja.getPohadjaID());
			pohadjaDTO.setStudent(new StudentDTO(pohadja.getStudent()));
			
			pohadjanjaDTO.add(pohadjaDTO);
		}
		
		return new ResponseEntity<>(pohadjanjaDTO, HttpStatus.OK);
	}
	
	//All teachers from course
	@RequestMapping(value="/{id}/profesori", method=RequestMethod.GET)
	public ResponseEntity<List<PredajeDTO>> getPredmetTeachers(@PathVariable Integer id){
		Predmet p = predmetService.findOne(id);
		Set<Predaje> predavanja=p.getPredavanja();
		List<PredajeDTO> predavanjaDTO=new ArrayList<>();
		for (Predaje predaje: predavanja) {
			PredajeDTO predajeDTO=new PredajeDTO();
			predajeDTO.setPredajeID(predaje.getPredajeID());
			predajeDTO.setProfesor(new ProfesorDTO(predaje.getProfesor()));
			predajeDTO.setTipPredavanja(predaje.getTipPredavanja());
			predajeDTO.setUloga(predaje.getUloga());
			
			predavanjaDTO.add(predajeDTO);
		}
		
		return new ResponseEntity<>(predavanjaDTO, HttpStatus.OK);
	}
	
	//Get tip exam from predmet
	@RequestMapping(value="/{id}/tipobaveze", method=RequestMethod.GET)
	public ResponseEntity<List<TipObavezeDTO>> getTipObavezeFromPredmet(@PathVariable Integer id){
		Predmet p=predmetService.findOne(id);
		if(p==null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		Set<TipObaveze> tipovi=p.getTipoviObaveza();
		List<TipObavezeDTO> tipoviDTO=new ArrayList<>();
		for (TipObaveze t: tipovi) {
			
			TipObavezeDTO tipDTO=new TipObavezeDTO();
			tipDTO.setTipObavezeID(t.getTipObavezeID());
			tipDTO.setDatum(t.getDatum());
			tipDTO.setNaziv(t.getNaziv());
			tipDTO.setOpis(t.getOpis());
			
			tipoviDTO.add(tipDTO);

		}
		return new ResponseEntity<>(tipoviDTO, HttpStatus.OK);
		
		
		
	}
	
}
