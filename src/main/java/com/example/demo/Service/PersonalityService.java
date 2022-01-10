package com.example.demo.Service;


import java.util.List;
import java.util.Optional;

import com.example.demo.Model.Personality;
import com.example.demo.Repository.PersonalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalityService {

    private final PersonalityRepository personalityRepository;

    @Autowired
    public PersonalityService(PersonalityRepository organizationRepository) {
        this.personalityRepository = organizationRepository;
    }
    
    public List<Personality> getPersonalitys(){
		return personalityRepository.findAll();
	}

    public Optional<Personality> getPersonality(Long id){
        return personalityRepository.findById(id);
    }

    public void addNewPersonality(Personality personality) {
        personalityRepository.save(personality);
    }

    public void deletePersonality(long id) {
        if (personalityRepository.existsById(id)){
            personalityRepository.deleteById(id);
        } else throw new IllegalStateException("Personality with id " +id  + " does not exist");
    }

}
