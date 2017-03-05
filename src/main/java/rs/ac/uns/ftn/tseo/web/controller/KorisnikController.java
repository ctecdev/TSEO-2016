package rs.ac.uns.ftn.tseo.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.tseo.model.Korisnik;
import rs.ac.uns.ftn.tseo.service.KorisnikService;
import rs.ac.uns.ftn.tseo.web.dto.KorisnikDTO;

@RestController
@RequestMapping(value="api/korisnici")
public class KorisnikController {
	@Autowired
	private KorisnikService korService;
	
	//FindAll
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<KorisnikDTO>> getAllUsers(){
		List<Korisnik> korisnici=korService.findAll();
		List<KorisnikDTO> korisniciDTO=new ArrayList<>();
		for (Korisnik k : korisnici) {
			korisniciDTO.add(new KorisnikDTO(k));
		}
		return new ResponseEntity<>(korisniciDTO, HttpStatus.OK);
	}
	
	//Get one
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<KorisnikDTO> getKorisnik(@PathVariable Integer id){
		Korisnik kor=korService.findOne(id);
		if(kor==null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(new KorisnikDTO(kor), HttpStatus.OK);
	}
	
	//Delete
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteKorisnik(@PathVariable Integer id){
		Korisnik k=korService.findOne(id);
		if(k!=null){
			korService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	//Find by username and password
//	@RequestMapping(value="/{username}/{password}", method=RequestMethod.POST)
//	public ResponseEntity<KorisnikDTO> findByUsernameAndPassword(
//			@RequestParam String username, @RequestParam String password){
//		Korisnik kor=korService.findByKorisnickoImeAndLozinka(username, password);
//		if(kor==null)
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		
//		return new ResponseEntity<>(new KorisnikDTO(kor), HttpStatus.OK);
//	}

}
