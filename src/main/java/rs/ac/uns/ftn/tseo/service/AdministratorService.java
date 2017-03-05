package rs.ac.uns.ftn.tseo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.tseo.model.Administrator;
import rs.ac.uns.ftn.tseo.model.Korisnik;
import rs.ac.uns.ftn.tseo.repository.AdministratorRepository;

@Service
public class AdministratorService {
	
	@Autowired
	AdministratorRepository adminRepo;
	
	public Administrator findOne(Integer adminID){
		return adminRepo.findOne(adminID);
	}
	
	public List<Administrator> findAll(){
		return adminRepo.findAll();
	}
	
	public Administrator save(Administrator a){
		return adminRepo.save(a);
	}
	
	public void remove(Integer adminID){
		adminRepo.delete(adminID);
	}
	
	public Page<Administrator> findAll(Pageable page){
		return adminRepo.findAll(page);
	}
	
	public Administrator findOneByKorisnik(Korisnik korisnik){
		return adminRepo.findOneByKorisnik(korisnik);
	}
}
