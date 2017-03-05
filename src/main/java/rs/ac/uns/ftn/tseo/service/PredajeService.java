package rs.ac.uns.ftn.tseo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.tseo.model.Predaje;
import rs.ac.uns.ftn.tseo.model.Predmet;
import rs.ac.uns.ftn.tseo.model.Profesor;
import rs.ac.uns.ftn.tseo.repository.PredajeRepository;

@Service
public class PredajeService {
	
	@Autowired
	PredajeRepository predajeRepo;
	
	public Predaje findOne(Integer predajeID){
		return predajeRepo.findOne(predajeID);
	}
	
	public List<Predaje> findAll(){
		return predajeRepo.findAll();
	}
	
	public Predaje save(Predaje p){
		return predajeRepo.save(p);
	}
	
	public void remove(Integer predajeID){
		predajeRepo.delete(predajeID);
	}
	
	public List<Predaje> findAllByPredmet(Predmet predmet){
		return predajeRepo.findAllByPredmet(predmet);
	}
	
	public List<Predaje> findAllByProfesor(Profesor profesor){
		return predajeRepo.findAllByProfesor(profesor);
	}
	
}
