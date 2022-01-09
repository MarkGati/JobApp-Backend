package com.example.demo.Controller;

import java.util.*;

import com.example.demo.Model.Organization;
import com.example.demo.Service.OrganizationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/organization")
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }
    
    @GetMapping
	public List<Organization> getOrganizations(){
		return organizationService.getOrganizations();
	}

    @GetMapping(path = "{id}")
    public Optional<Organization> getOrganization(@PathVariable("id") long id){
        return organizationService.getOrganization(id);
    }

    @PostMapping
    public void registerNewOrganization(@RequestBody Organization organization){
        organizationService.addNewOrganization(organization);
    }

    @DeleteMapping(path = "{id}")
    public void deleteOrganization(@PathVariable("id") long id){
        organizationService.deleteOrganization(id);
    }

    
}
