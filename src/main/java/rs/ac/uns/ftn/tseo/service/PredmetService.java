package rs.ac.uns.ftn.tseo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.tseo.model.Predmet;
import rs.ac.uns.ftn.tseo.repository.PredmetRepository;

@Service
public class PredmetService {
	
	@Autowired
	PredmetRepository predRepo;
	
	public Predmet findOne(Integer predmetID){
		return predRepo.findOne(predmetID);
	}
	
	public List<Predmet> findAll(){
		return predRepo.findAll();
	}
	
	public Predmet save(Predmet p){
		return predRepo.save(p);
	}
	
	public void remove(Integer predmetID){
		predRepo.delete(predmetID);
	}
	
	public Predmet findOneByNaziv(String naziv){
		return predRepo.findOneByNaziv(naziv);
	}
	
	public Page<Predmet> findAll(Pageable page){
		return predRepo.findAll(page);
	}
	
}
