package com.ericvizu.backendpc.services;

import com.ericvizu.backendpc.dto.RamDTO;
import com.ericvizu.backendpc.dto.StockDTO;
import com.ericvizu.backendpc.entities.Ram;
import com.ericvizu.backendpc.entities.Stock;
import com.ericvizu.backendpc.repositories.RamRepository;
import com.ericvizu.backendpc.services.exceptions.DatabaseException;
import com.ericvizu.backendpc.services.exceptions.DuplicateItemException;
import com.ericvizu.backendpc.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RamService {

    @Autowired
    private RamRepository repository;
    @Autowired
    private StockService stockService;

    // Create Ram
    public Ram create(RamDTO obj) {
        Ram ram = new Ram(obj);
        for (Ram m : findAll()) {
            if ((Objects.equals(m.getName().toUpperCase(), ram.getName().toUpperCase())) && (Objects.equals(m.getBrand().toUpperCase(), ram.getBrand().toUpperCase()))) {
                throw new DuplicateItemException("Ram with same name found");
            }
        }
        StockDTO stockDTO = new StockDTO("ram", obj.initialQuantity(), ram.getName());
        Stock stock = stockService.create(stockDTO);
        ram.setStock(stock);
        return repository.save(ram);
    }

    // Read Ram
    public Ram read(Long id) {
        try {
            Optional<Ram> obj = repository.findById(id);
            return obj.orElseThrow(() -> new ResourceNotFoundException(id));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Missing id number.");
        }
    }

    // Update Ram
    public Ram update(Long id, RamDTO obj) {
        try {
            Ram entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    // Delete Ram
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

    public List<Ram> findAll() {
        return repository.findAll();
    }

    // Update each Ram entry
    // Method has to be updated if entity gets new parameters
    public void updateData(Ram entity, RamDTO obj) {
        if (!(obj.brand() == null)) entity.setBrand(obj.brand());
        if (!(obj.name() == null)) entity.setName(obj.name());
        if (!(obj.gen() == null)) entity.setGen(obj.gen());
        if (!(obj.size() == null)) entity.setSize(obj.size());
        if (!(obj.freq() == null)) entity.setFreq(obj.freq());
        if (!(obj.latency() == null)) entity.setLatency(obj.latency());
    }

}
