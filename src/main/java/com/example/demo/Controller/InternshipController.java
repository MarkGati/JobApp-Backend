package com.example.demo.Controller;

import java.util.*;

import com.example.demo.Model.Internship;
import com.example.demo.Service.InternshipService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/internship")
public class InternshipController {

    private final InternshipService internshipService;

    @Autowired
    public InternshipController(InternshipService internshipService) {
        this.internshipService = internshipService;
    }
    
    @GetMapping
	public List<Internship> getInternships(){
		return internshipService.getInternships();
	}
    
    @GetMapping(path = "{id}")
    public Optional<Internship> getInternship(@PathVariable("id") long id){
        return internshipService.getInternship(id);
    }

    @GetMapping(path = "byDomain/{id}")
    public List<Internship> getIntershipByDomain(@PathVariable("id") long id){
        return internshipService.getInternshipsByDomain(id);
    }

    @PostMapping
    public void registerNewInternship(@RequestBody Internship internship){
        internshipService.addNewInternship(internship);
    }

    @DeleteMapping(path = "{id}")
    public void deleteInternship(@PathVariable("id") long id){
        internshipService.deleteInternship(id);
    }

    
}
