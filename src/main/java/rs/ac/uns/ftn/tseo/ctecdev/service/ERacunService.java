package rs.ac.uns.ftn.tseo.ctecdev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.tseo.ctecdev.model.ERacun;
import rs.ac.uns.ftn.tseo.ctecdev.repository.ERacunRepository;

@Service
public class ERacunService {

	@Autowired
	ERacunRepository eRacunRepo;
	
	public ERacun findOne(Integer eRacunID){
		return eRacunRepo.findOne(eRacunID);
	}
	
	public List<ERacun> findAll(){
		return eRacunRepo.findAll();
	}
	
	public ERacun save(ERacun e){
		return eRacunRepo.save(e);
	}
	
	public void remove(Integer eRacunID){
		eRacunRepo.delete(eRacunID);
	}
	
}
