package rs.ac.uns.ftn.tseo.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.tseo.model.Obaveza;
import rs.ac.uns.ftn.tseo.model.TipObaveze;
import rs.ac.uns.ftn.tseo.service.ObavezaService;
import rs.ac.uns.ftn.tseo.service.PredmetService;
import rs.ac.uns.ftn.tseo.service.TipObavezeService;
import rs.ac.uns.ftn.tseo.web.dto.ObavezaDTO;
import rs.ac.uns.ftn.tseo.web.dto.StudentDTO;
import rs.ac.uns.ftn.tseo.web.dto.TipObavezeDTO;

@RestController
@RequestMapping(value="api/tipobaveze")
public class TipObavezeController {
	@Autowired
	private TipObavezeService tipService;
	@Autowired
	private PredmetService predService;
	
	@Autowired
	private ObavezaService obavezaService;
	
	/*//GET ALL
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<TipObavezeDTO>> getAllTipObaveze(){
		List<TipObaveze> tipoviObaveza = tipService.findAll();
		//convert obaveze to DTOs
		List<TipObavezeDTO> tipoviObavezaDTO = new ArrayList<>();
		for (TipObaveze t : tipoviObaveza){
			tipoviObavezaDTO.add(new TipObavezeDTO(t));
		}
		
		return new ResponseEntity<>(tipoviObavezaDTO, HttpStatus.OK);
	}*/
	
	//Get one
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<TipObavezeDTO> getTipObaveze(@PathVariable Integer id){
		TipObaveze tip=tipService.findOne(id);
		if(tip==null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(new TipObavezeDTO(tip), HttpStatus.OK);
	}
	
	//Add
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<TipObavezeDTO> createTipObaveze(@RequestBody TipObavezeDTO tipDTO){
		TipObaveze tip=new TipObaveze();
		
		tip.setDatum(tipDTO.getDatum());
		tip.setNaziv(tipDTO.getNaziv());
		tip.setOpis(tipDTO.getOpis());
		tip.setPredmet(predService.findOne(tipDTO.getPredmet().getPredmetID()));
		
		tipService.save(tip);
		
		return new ResponseEntity<>(new TipObavezeDTO(tip), HttpStatus.CREATED);
		
	}
	
	//Update
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<TipObavezeDTO> updateTipObaveze(@RequestBody TipObavezeDTO tipDTO){
		TipObaveze tip=tipService.findOne(tipDTO.getTipObavezeID());
		
		if(tip==null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		
		tip.setDatum(tipDTO.getDatum());
		tip.setNaziv(tipDTO.getNaziv());
		tip.setOpis(tipDTO.getOpis());
		
		tipService.save(tip);
		
		return new ResponseEntity<>(new TipObavezeDTO(tip), HttpStatus.OK);
		
	}
	
	//Delete
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteTipObaveze(@PathVariable Integer id){
		TipObaveze tip=tipService.findOne(id);
		if(tip!=null){
			
			//obaveze
			for (Obaveza o : tip.getObaveze()){
				obavezaService.remove(o.getObavezaID());
			}
			
			tipService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	//Get all exams from tip obaveze
	@RequestMapping(value="/{id}/obaveze", method=RequestMethod.GET)
	public ResponseEntity<List<ObavezaDTO>> getObavezeFromTip(@PathVariable Integer id){
		TipObaveze tip=tipService.findOne(id);
		if(tip==null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		Set<Obaveza> obaveze=tip.getObaveze();
		List<ObavezaDTO> obavezeDTO=new ArrayList<>();
		for (Obaveza o : obaveze) {
			ObavezaDTO oDTO=new ObavezaDTO();
			oDTO.setBrojBodova(o.getBrojBodova());
			oDTO.setOcena(o.getOcena());
			oDTO.setPolozeno(o.getPolozeno());
			oDTO.setStudent(new StudentDTO(o.getStudent()));
			
			obavezeDTO.add(oDTO);
		}
		
		return new ResponseEntity<>(obavezeDTO, HttpStatus.OK);
		
	}
	
}
