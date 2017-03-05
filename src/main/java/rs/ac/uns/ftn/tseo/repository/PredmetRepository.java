package rs.ac.uns.ftn.tseo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.tseo.model.Predmet;

public interface PredmetRepository extends JpaRepository <Predmet, Integer>{
	
	Predmet findOneByNaziv (String naziv);

}
