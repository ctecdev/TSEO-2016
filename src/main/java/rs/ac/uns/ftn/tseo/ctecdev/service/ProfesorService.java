package rs.ac.uns.ftn.tseo.ctecdev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.tseo.ctecdev.model.Korisnik;
import rs.ac.uns.ftn.tseo.ctecdev.model.Profesor;
import rs.ac.uns.ftn.tseo.ctecdev.repository.ProfesorRepository;

@Service
public class ProfesorService {
	
	@Autowired
	ProfesorRepository profRepo;
	
	public Profesor findOne(Integer profesorID){
		return profRepo.findOne(profesorID);
	}
	
	public List<Profesor> findAll(){
		return profRepo.findAll();
	}
	
	public Profesor save(Profesor p){
		return profRepo.save(p);
	}
	
	public void remove(Integer profesorID){
		profRepo.delete(profesorID);
	}
	
	public List<Profesor> findAllByZvanje(String zvanje){
		return profRepo.findAllByZvanje(zvanje);
	}
	
	public Page<Profesor> findAll(Pageable page){
		return profRepo.findAll(page);
	}
	
	public Profesor findOneByKorisnik(Korisnik korisnik){
		return profRepo.findOneByKorisnik(korisnik);
	}
}
