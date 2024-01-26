package com.ericvizu.backendpc.services;

import com.ericvizu.backendpc.dto.MotherboardDTO;
import com.ericvizu.backendpc.dto.StockDTO;
import com.ericvizu.backendpc.entities.Motherboard;
import com.ericvizu.backendpc.entities.Stock;
import com.ericvizu.backendpc.repositories.MotherboardRepository;
import com.ericvizu.backendpc.services.exceptions.DatabaseException;
import com.ericvizu.backendpc.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotherboardService {

    @Autowired
    private MotherboardRepository repository;
    @Autowired
    private StockService stockService;

    // Create Motherboard
    public Motherboard create(MotherboardDTO obj) {
        Motherboard motherboard = new Motherboard(obj);
//        for (Motherboard m : findAll()) {
//            if ((Objects.equals(m.getName().toUpperCase(), motherboard.getName().toUpperCase())) && (Objects.equals(m.getBrand().toUpperCase(), motherboard.getBrand().toUpperCase()))) {
//                throw new DuplicateItemException("Motherboard with same name found");
//            }
//        }
        StockDTO stockDTO = new StockDTO("motherboard", obj.initialQuantity());
        Stock stock = stockService.create(stockDTO);
        motherboard.setStock(stock);
        return repository.save(motherboard);
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
    public Motherboard update(Long id, MotherboardDTO obj) {
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

    public List<Motherboard> findAll() {
        return repository.findAll();
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    // Update each Motherboard entry
    // Method has to be updated if entity gets new parameters
    public void updateData(Motherboard entity, MotherboardDTO obj) {
        if (!(obj.brand() == null)) entity.setBrand(obj.brand());
        if (!(obj.name() == null)) entity.setName(obj.name());
        if (!(obj.socket() == null)) entity.setSocket(obj.socket());
        if (!(obj.ramGen() == null)) entity.setRamGen(obj.ramGen());
        if (!(obj.ramSlots() == null)) entity.setRamSlots(obj.ramSlots());
        if (!(obj.ramFreq() == null)) entity.setRamFreq(obj.ramFreq());
        if (!(obj.sataSlots() == null)) entity.setSataSlots(obj.sataSlots());
        if (!(obj.m2Gen3Slots() == null)) entity.setM2Gen3Slots(obj.m2Gen3Slots());
        if (!(obj.m2Gen4Slots() == null)) entity.setM2Gen4Slots(obj.m2Gen4Slots());
    }

}
