package com.ericvizu.backendpc.services;

import com.ericvizu.backendpc.entities.Motherboard;
import com.ericvizu.backendpc.repositories.MotherboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MotherboardService {

    @Autowired
    private MotherboardRepository repository;

    // Create Motherboard
    public Motherboard create(Motherboard obj) {
        return repository.save(obj);
    }

    // Read Motherboard
    public Motherboard read(Long id){
        Optional<Motherboard> obj = repository.findById(id);
        return obj.orElse(null); // Missing exception treating
    }


}
