package rs.ac.uns.ftn.tseo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.tseo.model.Korisnik;
import rs.ac.uns.ftn.tseo.model.Student;
import rs.ac.uns.ftn.tseo.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public Student findOne(Integer studentID){
		return studentRepository.findOne(studentID);
	}
	
	public List<Student> findAll(){
		return studentRepository.findAll();
	}
	
	public Student save(Student s){
		return studentRepository.save(s);
	}
	
	public void remove(Integer studentID){
		studentRepository.delete(studentID);
	}
	
	public Student findOneByBrojIndexa(String brojIndexa){
		return studentRepository.findOneByBrojIndexa(brojIndexa);
	}
	
	public Page<Student> findAll(Pageable page) {
		return studentRepository.findAll(page);
	}
	
	public Student findOneByKorisnik(Korisnik korisnik){
		return studentRepository.findOneByKorisnik(korisnik);
	}

	
}
