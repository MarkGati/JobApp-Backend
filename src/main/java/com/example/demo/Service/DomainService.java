package com.example.demo.Service;


import java.util.List;
import java.util.Optional;

import com.example.demo.Model.Domain;
import com.example.demo.Repository.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainService {

    private final DomainRepository domainRepository;

    @Autowired
    public DomainService(DomainRepository domainRepository) {
        this.domainRepository = domainRepository;
    }
    
    public List<Domain> getDomains(){
		return domainRepository.findAll();
	}

    public Optional<Domain> getDomain(Long id){
        return domainRepository.findById(id);
    }

    public void addNewDomain(Domain domain) {
        domainRepository.save(domain);
    }

    public void deleteDomain(long id) {
        if (domainRepository.existsById(id)){
            domainRepository.deleteById(id);
        } else throw new IllegalStateException("Domain with id " +id  + " does not exist");
    }

}
