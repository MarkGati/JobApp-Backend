package com.example.demo.Service;


import java.util.List;
import java.util.Optional;

import com.example.demo.Model.Internship;
import com.example.demo.Repository.InternshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InternshipService {

    private final InternshipRepository internshipRepository;

    @Autowired
    public InternshipService(InternshipRepository internshipRepository) {
        this.internshipRepository = internshipRepository;
    }
    
    public List<Internship> getInternships(){
		return internshipRepository.findAll();
	}

    public Optional<Internship> getInternship(Long id){
        return internshipRepository.findById(id);
    }

    public void addNewInternship(Internship internship) {
        internshipRepository.save(internship);
    }

    public void deleteInternship(long id) {
        if (internshipRepository.existsById(id)){
            internshipRepository.deleteById(id);
        } else throw new IllegalStateException("Internship with id " +id  + " does not exist");
    }

}
