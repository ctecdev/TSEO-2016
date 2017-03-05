package rs.ac.uns.ftn.tseo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.tseo.model.Pohadja;
import rs.ac.uns.ftn.tseo.model.Predmet;
import rs.ac.uns.ftn.tseo.model.Student;
import rs.ac.uns.ftn.tseo.repository.PohadjaRepository;

@Service
public class PohadjaService {
	
	@Autowired
	PohadjaRepository pohadjaRepo;
	
	public Pohadja findOne(Integer pohadjaID){
		return pohadjaRepo.findOne(pohadjaID);
	}
	
	public List<Pohadja> findAll(){
		return pohadjaRepo.findAll();
	}
	
	public Pohadja save(Pohadja p){
		return pohadjaRepo.save(p);
	}
	
	public void remove(Integer pohadjaID){
		pohadjaRepo.delete(pohadjaID);
	}
	
	public List<Pohadja> find(Student student){
		return pohadjaRepo.findAllByStudent(student);
	}
	
	public List<Pohadja> findAllByPredmet(Predmet predmet){
		return pohadjaRepo.findAllByPredmet(predmet);
	}
	
}
