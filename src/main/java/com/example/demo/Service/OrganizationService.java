package com.example.demo.Service;


import java.util.List;
import com.example.demo.Model.Organization;
import com.example.demo.Repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }
    
    public List<Organization> getOrganizations(){
		return organizationRepository.findAll();
	}

    public Organization getOrganization(Long id){
        return organizationRepository.getById(id);
    }

    public void addNewOrganization(Organization organization) {
        organizationRepository.save(organization);
    }

    public void deleteOrganization(long id) {
        if (organizationRepository.existsById(id)){
            organizationRepository.deleteById(id);
        } else throw new IllegalStateException("Organization with id " +id  + " does not exist");
    }

}
