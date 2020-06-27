package com.example.projecttwo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DataStructureController {
    private final DataStructureRepository repository;
    DataStructureController(DataStructureRepository repository){
        this.repository = repository;
    }

    @GetMapping("/datastructure")
    List<DataStructure> all() {
        return repository.findAll();
    }

    @PostMapping("/datastructures")
    DataStructure newDataStructure(@RequestBody DataStructure newDataStructure){
        return repository.save(newDataStructure);
    }

    @DeleteMapping("/datastructures/{id}")
    void deleteDataStructure(@PathVariable Long id){
        repository.deleteById(id);
    }
}
