package rs.ac.uns.ftn.tseo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.tseo.model.Pohadja;
import rs.ac.uns.ftn.tseo.model.Predmet;
import rs.ac.uns.ftn.tseo.model.Student;

public interface PohadjaRepository extends JpaRepository <Pohadja,Integer> {
	
	List<Pohadja> findAllByStudent(Student student);
	List<Pohadja> findAllByPredmet(Predmet predmet);
 
}
