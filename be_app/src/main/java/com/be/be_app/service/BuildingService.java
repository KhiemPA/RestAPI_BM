package com.be.be_app.service;

import com.be.be_app.model.Building;
import com.be.be_app.model.Employee;
import com.be.be_app.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Service

public class BuildingService {
    @Autowired
    public BuildingRepository buildingRepository;

    @RequestMapping("/buildings")
    public List<Building> getAllBuildings(){
        List<Building> buildings = new ArrayList<>();
        buildingRepository.findAll().forEach(buildings::add);
        return buildings;
    }
    public void addBuilding(Building building){
        buildingRepository.save(building);
    }
    public void updateBuilding(Long id, Building building) {
        Building building1 = buildingRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("Employee was not found")
        );
        building.setId(id);
        building1 = building;
        buildingRepository.save(building1);
    }
    public void deleteBuilding (Long id) {
        buildingRepository.deleteById(id);
    }

}
