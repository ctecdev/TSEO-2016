package rs.ac.uns.ftn.tseo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.tseo.model.Korisnik;

public interface KorisnikRepository extends JpaRepository <Korisnik,Integer> {
	
	Korisnik findOneByImeAndPrezime(String ime, String prezime);
	Korisnik findOneByKorisnickoImeAndLozinka(String korisnickoIme, String lozinka);

}
