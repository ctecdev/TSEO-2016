package rs.ac.uns.ftn.tseo.ctecdev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.tseo.ctecdev.model.Predaje;
import rs.ac.uns.ftn.tseo.ctecdev.model.Predmet;
import rs.ac.uns.ftn.tseo.ctecdev.model.Profesor;

public interface PredajeRepository extends JpaRepository <Predaje,Integer>{
	
	List<Predaje> findAllByPredmet(Predmet predmet);
	List<Predaje> findAllByProfesor(Profesor profesor);
	
}
