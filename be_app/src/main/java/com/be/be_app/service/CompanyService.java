package com.be.be_app.service;


import com.be.be_app.model.Building;
import com.be.be_app.model.Company;
import com.be.be_app.repository.BuildingRepository;
import com.be.be_app.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    public CompanyRepository companyRepository;
    @RequestMapping("/companies")
    public List<Company> getAllCompanies(){
        List<Company> companies = new ArrayList<>();
        companyRepository.findAll().forEach(companies::add);
        return companies;
    }
    public void addCompany(Company company) { companyRepository.save(company);}
    public void updateCompany(Long id, Company company) {
        Company company1 = companyRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("Conpany was not found")
        );
        company.setId(id);
        company1 = company;
        companyRepository.save(company1);}
    public void deleteCompany(Long id) { companyRepository.deleteById(id);}
}
