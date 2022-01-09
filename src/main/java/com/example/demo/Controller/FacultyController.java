package com.example.demo.Controller;

import java.util.*;

import com.example.demo.Model.Faculty;
import com.example.demo.Service.FacultyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    
    @GetMapping
	public List<Faculty> getFacultys(){
		return facultyService.getFacultys();
	}

    @GetMapping(path = "{id}")
    public Optional<Faculty> getFaculty(@PathVariable("id") long id){
        return facultyService.getFaculty(id);
    }

    @PostMapping
    public void registerNewFaculty(@RequestBody Faculty faculty){
        facultyService.addNewFaculty(faculty);
    }

    @DeleteMapping(path = "{id}")
    public void deleteFaculty(@PathVariable("id") long id){
        facultyService.deleteFaculty(id);
    }

    
}
