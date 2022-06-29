package com.be.be_app.controller;


import com.be.be_app.model.Contract;
import com.be.be_app.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api")
public class ContractController {
   @Autowired
   private ContractService contractService;
   @RequestMapping("/contracts")
    public List<Contract> getAllContracts(){
       return contractService.getAllContracts();
   }
   @RequestMapping(method = RequestMethod.POST, value = "/contracts")
    public void addContract(@RequestBody Contract contract) {
       contractService.addContract(contract);
   }
   @RequestMapping(method = RequestMethod.PUT,value = "/contracts/{id}")
    public void updateContract(@PathVariable Long id, @RequestBody Contract contract) {
       contractService.updateContract(id,contract);
   }
    @RequestMapping(method = RequestMethod.DELETE, value = "/contracts/{id}")
   public void deleteContract(@PathVariable Long id) {
       contractService.deleteContract(id);
   }
}
