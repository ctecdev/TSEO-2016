package rs.ac.uns.ftn.tseo.web.dto;

import rs.ac.uns.ftn.tseo.model.Dokument;

public class DokumentDTO {

	private Integer dokumentID;
	private StudentDTO student;
	private String naziv;
	private String tip;
	private String putanjaDoDokumenta;
	
	
	
	public DokumentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DokumentDTO(Dokument dokument) {
		this.dokumentID = dokument.getDokumentID();
		this.student = new StudentDTO(dokument.getStudent());
		this.naziv = dokument.getNaziv();
		this.tip = dokument.getTip();
		this.putanjaDoDokumenta = dokument.getPutanjaDoDokumenta();
	}

	public DokumentDTO(Integer dokumentID, StudentDTO student, String naziv, String tip, String putanjaDoDokumenta) {
		super();
		this.dokumentID = dokumentID;
		this.student = student;
		this.naziv = naziv;
		this.tip = tip;
		this.putanjaDoDokumenta = putanjaDoDokumenta;
	}

	
	
	public Integer getDokumentID() {
		return dokumentID;
	}

	public void setDokumentID(Integer dokumentID) {
		this.dokumentID = dokumentID;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getPutanjaDoDokumenta() {
		return putanjaDoDokumenta;
	}

	public void setPutanjaDoDokumenta(String putanjaDoDokumenta) {
		this.putanjaDoDokumenta = putanjaDoDokumenta;
	}
	
	
}
