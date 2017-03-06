package rs.ac.uns.ftn.tseo.ctecdev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.tseo.ctecdev.model.Predmet;

public interface PredmetRepository extends JpaRepository <Predmet, Integer>{
	
	Predmet findOneByNaziv (String naziv);

}
