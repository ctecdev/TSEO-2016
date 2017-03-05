package rs.ac.uns.ftn.tseo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.tseo.model.Obaveza;
import rs.ac.uns.ftn.tseo.repository.ObavezaRepository;

@Service
public class ObavezaService {

	@Autowired
	ObavezaRepository obavezaRepo;
	
	public Obaveza findOne(Integer obavezaID){
		return obavezaRepo.findOne(obavezaID);
	}
	
	public List<Obaveza> findAll(){
		return obavezaRepo.findAll();
	}
	
	public Obaveza save(Obaveza o){
		return obavezaRepo.save(o);
	}
	
	public void remove(Integer obavezaID){
		obavezaRepo.delete(obavezaID);
	}
	
	
}
