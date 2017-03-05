package rs.ac.uns.ftn.tseo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.tseo.model.Dokument;

public interface DokumentRepository extends JpaRepository <Dokument,Integer>{

	Dokument findOneByNaziv(String naziv);	
	List<Dokument> findAllByTip(String tip);

}
