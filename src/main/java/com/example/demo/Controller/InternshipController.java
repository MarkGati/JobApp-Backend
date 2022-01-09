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

    @PostMapping
    public void registerNewInternship(@RequestBody Internship internship){
        internshipService.addNewInternship(internship);
    }

    @DeleteMapping(path = "{id}")
    public void deleteInternship(@PathVariable("id") long id){
        internshipService.deleteInternship(id);
    }

    
}
