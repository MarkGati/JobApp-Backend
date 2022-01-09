package com.example.demo.Service;


import java.util.List;
import com.example.demo.Model.Faculty;
import com.example.demo.Repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }
    
    public List<Faculty> getFacultys(){
		return facultyRepository.findAll();
	}

    public Faculty getFaculty(Long id){
        return facultyRepository.getById(id);
    }

    public void addNewFaculty(Faculty faculty) {
        facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
        if (facultyRepository.existsById(id)){
            facultyRepository.deleteById(id);
        } else throw new IllegalStateException("Faculty with id " +id  + " does not exist");
    }

}
