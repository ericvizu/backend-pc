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
    public Motherboard read(Long id) {
        Optional<Motherboard> obj = repository.findById(id);
        return obj.orElse(null); // Missing exception treating
    }

    // Update Motherboard
    public Motherboard update(Long id, Motherboard obj) {
        Motherboard entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity); // Missing exception treating
    }

    // Delete Motherboard
    public void delete(Long id) {
        repository.deleteById(id); // Missing exception treating
    }

    // Update each Motherboard entry
    // Method has to be updated if entity gets new parameters
    public void updateData(Motherboard entity, Motherboard obj) {
        entity.setName(obj.getName());
        entity.setSocket(obj.getSocket());
        entity.setRamGen(obj.getRamGen());
        entity.setRamSlots(obj.getRamSlots());
        entity.setRamFreq(obj.getRamFreq());
        entity.setSataSlots(obj.getSataSlots());
        entity.setM2Gen4Slots(obj.getM2Gen4Slots());
        entity.setM2Gen3Slots(obj.getM2Gen3Slots());
    }

}
