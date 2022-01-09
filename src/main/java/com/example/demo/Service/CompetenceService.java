package com.example.demo.Service;


import java.util.List;
import com.example.demo.Model.Competence;
import com.example.demo.Repository.CompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompetenceService {

    private final CompetenceRepository competenceRepository;

    @Autowired
    public CompetenceService(CompetenceRepository competenceRepository) {
        this.competenceRepository = competenceRepository;
    }
    
    public List<Competence> getCompetences(){
		return competenceRepository.findAll();
	}

    public Competence getCompetence(Long id){
        return competenceRepository.getById(id);
    }

    public void addNewCompetence(Competence competence) {
        competenceRepository.save(competence);
    }

    public void deleteCompetence(long id) {
        if (competenceRepository.existsById(id)){
            competenceRepository.deleteById(id);
        } else throw new IllegalStateException("Competence with id " +id  + " does not exist");
    }

}
