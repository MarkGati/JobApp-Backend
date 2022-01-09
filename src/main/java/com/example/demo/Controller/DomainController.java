package com.example.demo.Controller;

import java.util.*;

import com.example.demo.Model.Domain;
import com.example.demo.Service.DomainService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/domain")
public class DomainController {

    private final DomainService domainService;

    @Autowired
    public DomainController(DomainService domainService) {
        this.domainService = domainService;
    }
    
    @GetMapping
	public List<Domain> getDomains(){
		return domainService.getDomains();
	}

    @PostMapping
    public void registerNewDomain(@RequestBody Domain domain){
        domainService.addNewDomain(domain);
    }

    @DeleteMapping(path = "{id}")
    public void deleteDomain(@PathVariable("id") long id){
        domainService.deleteDomain(id);
    }

    
}
