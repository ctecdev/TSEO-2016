package rs.ac.uns.ftn.tseo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.tseo.model.Administrator;
import rs.ac.uns.ftn.tseo.model.Korisnik;

public interface AdministratorRepository extends JpaRepository <Administrator,Integer> {
	
	Administrator findOneByKorisnik(Korisnik korisnik);
	
}
