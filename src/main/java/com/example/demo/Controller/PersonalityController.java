package com.example.demo.Controller;

import java.util.*;
import com.example.demo.Model.Personality;
import com.example.demo.Service.PersonalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/personality")
public class PersonalityController {

    private final PersonalityService personalityService;

    @Autowired
    public PersonalityController(PersonalityService organizationService) {
        this.personalityService = organizationService;
    }
    
    @GetMapping
	public List<Personality> getPersonalitys(){
		return personalityService.getPersonalitys();
	}

    @GetMapping(path = "{id}")
    public Optional<Personality> getPersonality(@PathVariable("id") long id){
        return personalityService.getPersonality(id);
    }

    @PostMapping
    public void registerNewPersonality(@RequestBody Personality personality){
        personalityService.addNewPersonality(personality);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonality(@PathVariable("id") long id){
        personalityService.deletePersonality(id);
    }

    
}
