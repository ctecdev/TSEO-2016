package rs.ac.uns.ftn.tseo.ctecdev.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Administrator {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer adminID;
	
	// -> Korisnik
	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Korisnik korisnik;
	
	
	
	public Administrator() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Administrator(Integer adminID, Korisnik korisnik) {
		super();
		this.adminID = adminID;
		this.korisnik = korisnik;
	}



	public Integer getAdminID() {
		return adminID;
	}

	public void setAdminID(Integer adminID) {
		this.adminID = adminID;
	}



	public Korisnik getKorisnik() {
		return korisnik;
	}



	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}


	
}
