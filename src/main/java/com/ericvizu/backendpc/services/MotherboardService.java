package com.ericvizu.backendpc.services;

import com.ericvizu.backendpc.entities.Motherboard;
import com.ericvizu.backendpc.repositories.MotherboardRepository;
import com.ericvizu.backendpc.services.exceptions.DatabaseException;
import com.ericvizu.backendpc.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
        try {
            Optional<Motherboard> obj = repository.findById(id);
            return obj.orElseThrow(() -> new ResourceNotFoundException(id));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Missing id number.");
        }

    }

    // Update Motherboard
    public Motherboard update(Long id, Motherboard obj) {
        try {
            Motherboard entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    // Delete Motherboard
    public void delete(Long id) {
        try {
            if (!repository.existsById(id)) {
                throw new ResourceNotFoundException(id);
            }
            repository.deleteById(id);

        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Missing id number.");
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
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
