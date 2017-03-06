package rs.ac.uns.ftn.tseo.ctecdev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.tseo.ctecdev.model.Korisnik;
import rs.ac.uns.ftn.tseo.ctecdev.model.Student;

public interface StudentRepository extends JpaRepository <Student, Integer> {
	
	Student findOneByBrojIndexa(String brojIndexa);
	Student findOneByKorisnik(Korisnik korisnik);

}
