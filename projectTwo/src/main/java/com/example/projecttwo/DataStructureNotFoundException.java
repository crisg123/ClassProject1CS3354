package com.example.projecttwo;

class DataStructureNotFoundException extends RuntimeException {

    DataStructureNotFoundException(Long id) {
        super("Could not find dataStructure " + id);
    }
}
