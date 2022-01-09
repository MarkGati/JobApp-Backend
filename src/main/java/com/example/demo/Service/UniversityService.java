package com.example.demo.Service;


import java.util.List;
import com.example.demo.Model.University;
import com.example.demo.Repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniversityService {

    private final UniversityRepository universityRepository;

    @Autowired
    public UniversityService(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }
    
    public List<University> getUniversitys(){
		return universityRepository.findAll();
	}

    public University getUniversity(Long id){
        return universityRepository.getById(id);
    }

    public void addNewUniversity(University university) {
        universityRepository.save(university);
    }

    public void deleteUniversity(long id) {
        if (universityRepository.existsById(id)){
            universityRepository.deleteById(id);
        } else throw new IllegalStateException("University with id " +id  + " does not exist");
    }

}
