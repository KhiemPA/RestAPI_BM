package com.be.be_app.service;

import com.be.be_app.model.Building;
import com.be.be_app.model.Contract;
import com.be.be_app.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContractService {
    @Autowired

    public ContractRepository contractRepository;
    @RequestMapping("/contracts")
    public List<Contract> getAllContracts() {
        List<Contract> contracts = new ArrayList<>();
        contractRepository.findAll().forEach(contracts::add);
        return contracts;
    }

    public void addContract(Contract contract){
        contractRepository.save(contract);
    }
    public void updateContract(Long id, Contract contract) {
        Contract contract1 = contractRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("Contract was not found")
        );
        contract.setId(id);
        contract1 = contract;
        contractRepository.save(contract1);
    }
    public void deleteContract(Long id) {
        contractRepository.deleteById(id);
    }

}
