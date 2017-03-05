package rs.ac.uns.ftn.tseo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.tseo.model.Predaje;
import rs.ac.uns.ftn.tseo.model.Predmet;
import rs.ac.uns.ftn.tseo.model.Profesor;

public interface PredajeRepository extends JpaRepository <Predaje,Integer>{
	
	List<Predaje> findAllByPredmet(Predmet predmet);
	List<Predaje> findAllByProfesor(Profesor profesor);
	
}
