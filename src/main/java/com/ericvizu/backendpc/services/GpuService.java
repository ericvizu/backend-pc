package com.ericvizu.backendpc.services;

import com.ericvizu.backendpc.dto.GpuDTO;
import com.ericvizu.backendpc.dto.StockDTO;
import com.ericvizu.backendpc.entities.Gpu;
import com.ericvizu.backendpc.entities.Stock;
import com.ericvizu.backendpc.repositories.GpuRepository;
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
public class GpuService {

    @Autowired
    private GpuRepository repository;
    @Autowired
    private StockService stockService;

    // Create GPU
    public Gpu create(GpuDTO obj) {
        Gpu gpu = new Gpu(obj);
        for (Gpu c : findAll()) {
            if ((Objects.equals(c.getName().toUpperCase(), gpu.getName().toUpperCase())) && (Objects.equals(c.getBrand().toUpperCase(), gpu.getBrand().toUpperCase()))) {
                throw new DuplicateItemException("GPU with same name found");
            }
        }
        StockDTO stockDTO = new StockDTO("gpu", obj.initialQuantity(), gpu.getName());
        Stock stock = stockService.create(stockDTO);
        gpu.setStock(stock);
        return repository.save(gpu);
    }

    // Read GPU
    public Gpu read(Long id) {
        try {
            Optional<Gpu> obj = repository.findById(id);
            return obj.orElseThrow(() -> new ResourceNotFoundException(id));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Missing id number.");
        }
    }

    // Update GPU
    public Gpu update(Long id, GpuDTO obj) {
        try {
            Gpu entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    // Delete GPU
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

    public List<Gpu> findAll() {
        return repository.findAll();
    }

    // Update each GPU entry
    // Method has to be updated if entity gets new parameters
    public void updateData(Gpu entity, GpuDTO obj) {
        if (!(obj.brand() == null)) entity.setBrand(obj.brand());
        if (!(obj.name() == null)) entity.setName(obj.name());
        if (!(obj.baseClock() == null)) entity.setBaseClock(obj.baseClock());
        if (!(obj.boostClock() == null)) entity.setBoostClock(obj.boostClock());
        if (!(obj.vramSize() == null)) entity.setVramSize(obj.vramSize());
        if (!(obj.vramGen() == null)) entity.setVramGen(obj.vramGen());
        if (!(obj.tdp() == null)) entity.setTdp(obj.tdp());
    }

}
