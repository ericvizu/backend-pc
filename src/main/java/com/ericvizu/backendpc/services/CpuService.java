package com.ericvizu.backendpc.services;

import com.ericvizu.backendpc.dto.CpuDTO;
import com.ericvizu.backendpc.dto.StockDTO;
import com.ericvizu.backendpc.entities.Cpu;
import com.ericvizu.backendpc.entities.Stock;
import com.ericvizu.backendpc.repositories.CpuRepository;
import com.ericvizu.backendpc.services.exceptions.DatabaseException;
import com.ericvizu.backendpc.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CpuService {

    @Autowired
    private CpuRepository repository;
    @Autowired
    private StockService stockService;

    // Create CPU
    public Cpu create(CpuDTO obj) {
        Cpu cpu = new Cpu(obj);
//        for (Cpu c : findAll()) {
//            if ((Objects.equals(c.getName().toUpperCase(), cpu.getName().toUpperCase())) && (Objects.equals(c.getBrand().toUpperCase(), cpu.getBrand().toUpperCase()))) {
//                throw new DuplicateItemException("CPU with same name found");
//            }
//        }
        StockDTO stockDTO = new StockDTO("cpu", obj.initialQuantity(), cpu.getName());
        Stock stock = stockService.create(stockDTO);
        cpu.setStock(stock);
        return repository.save(cpu);
    }

    // Read CPU
    public Cpu read(Long id) {
        try {
            Optional<Cpu> obj = repository.findById(id);
            return obj.orElseThrow(() -> new ResourceNotFoundException(id));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Missing id number.");
        }
    }

    // Update CPU
    public Cpu update(Long id, CpuDTO obj) {
        try {
            Cpu entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    // Delete CPU
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

    public List<Cpu> findAll() {
        return repository.findAll();
    }

    // Update each CPU entry
    // Method has to be updated if entity gets new parameters
    public void updateData(Cpu entity, CpuDTO obj) {
        if (!(obj.brand() == null)) entity.setBrand(obj.brand());
        if (!(obj.name() == null)) entity.setName(obj.name());
        if (!(obj.socket() == null)) entity.setSocket(obj.socket());
        if (!(obj.threads() == null)) entity.setThreads(obj.threads());
        if (!(obj.cores() == null)) entity.setCores(obj.cores());
        if (!(obj.tdp() == null)) entity.setTdp(obj.tdp());
    }

}
