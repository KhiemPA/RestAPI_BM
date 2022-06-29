package com.be.be_app.controller;

import com.be.be_app.model.Building;
import com.be.be_app.repository.BuildingRepository;
import com.be.be_app.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api")
public class BuildingController {
    @Autowired
    private BuildingService buildingService;

    @RequestMapping("/buildings")
    public List<Building> getAllBuildings(){
        return buildingService.getAllBuildings();
    }
    @RequestMapping(method = RequestMethod.POST, value = "/buildings")
    public void addBuilding(@RequestBody Building building) {
        buildingService.addBuilding(building);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/buildings/{id}")
    public void deleteBuilding(@PathVariable Long id) {

        buildingService.deleteBuilding(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/buildings/{id}")
    public void updateBuilding(@PathVariable Long id, @RequestBody Building building) {
        buildingService.updateBuilding(id,building);
    }
}
