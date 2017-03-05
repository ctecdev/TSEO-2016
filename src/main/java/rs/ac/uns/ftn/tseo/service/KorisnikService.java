package rs.ac.uns.ftn.tseo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.tseo.model.Korisnik;
import rs.ac.uns.ftn.tseo.repository.KorisnikRepository;

@Service
public class KorisnikService {
	
	@Autowired
	KorisnikRepository korRepo;
	
	public Korisnik findOne(Integer korisnikID){
		return korRepo.findOne(korisnikID);
	}
	
	public List<Korisnik> findAll(){
		return korRepo.findAll();
	}
	
	public Korisnik save(Korisnik k){
		return korRepo.save(k);
	}
	
	public void remove(Integer korisnikID){
		korRepo.delete(korisnikID);
	}
	
	public Korisnik findOneByImeAndPrezime(String ime, String prezime){
		return korRepo.findOneByImeAndPrezime(ime, prezime);
	}
	
	public Korisnik findOneByKorisnickoImeAndLozinka(String korisnickoIme, String lozinka){
		return korRepo.findOneByKorisnickoImeAndLozinka(korisnickoIme, lozinka);
	}
	
}
