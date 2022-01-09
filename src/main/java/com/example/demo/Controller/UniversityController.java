package com.example.demo.Controller;

import java.util.*;

import com.example.demo.Model.University;
import com.example.demo.Service.UniversityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/university")
public class UniversityController {

    private final UniversityService universityService;

    @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }
    
    @GetMapping
	public List<University> getUniversitys(){
		return universityService.getUniversitys();
	}
    
    @GetMapping(path = "{id}")
    public Optional<University> getUser(@PathVariable("id") long id){
        return universityService.getUniversity(id);
    }

    @PostMapping
    public void registerNewUniversity(@RequestBody University universit){
        universityService.addNewUniversity(universit);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUniversity(@PathVariable("id") long id){
        universityService.deleteUniversity(id);
    }

    
}
