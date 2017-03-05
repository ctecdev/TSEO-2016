package rs.ac.uns.ftn.tseo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.tseo.model.ERacun;
import rs.ac.uns.ftn.tseo.model.Uplata;

public interface UplataRepository extends JpaRepository <Uplata, Integer> {
	
	List<Uplata> findAllByERacun(ERacun eRacun);
	List<Uplata> findAllByDatum(Date datum);
	List<Uplata> findAllBySvrha(String svrha);
	
}
