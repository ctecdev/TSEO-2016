package rs.ac.uns.ftn.tseo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.tseo.model.Korisnik;
import rs.ac.uns.ftn.tseo.model.Student;

public interface StudentRepository extends JpaRepository <Student, Integer> {
	
	Student findOneByBrojIndexa(String brojIndexa);
	Student findOneByKorisnik(Korisnik korisnik);

}
