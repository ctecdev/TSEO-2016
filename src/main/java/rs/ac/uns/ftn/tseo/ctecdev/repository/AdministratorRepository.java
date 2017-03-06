package rs.ac.uns.ftn.tseo.ctecdev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.tseo.ctecdev.model.Administrator;
import rs.ac.uns.ftn.tseo.ctecdev.model.Korisnik;

public interface AdministratorRepository extends JpaRepository <Administrator,Integer> {
	
	Administrator findOneByKorisnik(Korisnik korisnik);
	
}
