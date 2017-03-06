package rs.ac.uns.ftn.tseo.ctecdev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.tseo.ctecdev.model.Korisnik;
import rs.ac.uns.ftn.tseo.ctecdev.model.Profesor;

public interface ProfesorRepository extends JpaRepository <Profesor, Integer> {
	
	List<Profesor> findAllByZvanje(String zvanje);
	Profesor findOneByKorisnik(Korisnik korisnik);

}
