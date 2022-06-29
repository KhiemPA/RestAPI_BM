package com.be.be_app.controller;


import com.be.be_app.model.Company;
import com.be.be_app.service.CompanyService;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin(origins = "*")
@RequestMapping("api")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @RequestMapping("/companies")
    public List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
    }
    @RequestMapping(method = RequestMethod.POST, value = "/companies")
    public void addCompany(@RequestBody Company company){
        companyService.addCompany(company);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/companies/{id}")
    public void updateCompany(@PathVariable Long id,@RequestBody Company company){
        companyService.updateCompany(id,company);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/companies/{id}")
    public void deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
    }
}
