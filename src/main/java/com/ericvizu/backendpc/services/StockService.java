package com.ericvizu.backendpc.services;

import com.ericvizu.backendpc.dto.StockDTO;
import com.ericvizu.backendpc.entities.Stock;
import com.ericvizu.backendpc.repositories.CpuRepository;
import com.ericvizu.backendpc.repositories.MotherboardRepository;
import com.ericvizu.backendpc.repositories.StockRepository;
import com.ericvizu.backendpc.services.exceptions.DatabaseException;
import com.ericvizu.backendpc.services.exceptions.InvalidNumberException;
import com.ericvizu.backendpc.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository repository;
    @Autowired
    private MotherboardRepository motherboardRepository;
    @Autowired
    private CpuRepository cpuRepository;

    // Create new item in Stock from other categories
    public Stock create(StockDTO obj) {
        Stock stock = new Stock(obj);
        return repository.save(stock);
    }

    // Read Stock with Category and Id from the tb_[category]
    public Stock read(Long id) {
        try {
            Optional<Stock> obj = repository.findById(id);
            return obj.orElseThrow(() -> new ResourceNotFoundException(id));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Missing id number.");
        }
    }

    // Update Stock
    public Stock update(Long id, String quantity) {
        try {
            Stock entity = repository.getReferenceById(id);
            stockVariation(entity, quantity);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public void stockVariation(Stock entity, String quantity) {
        try {
            entity.setQuantity(entity.getQuantity() + Integer.parseInt(quantity));
        } catch (NumberFormatException e) {
            throw new InvalidNumberException("Invalid number parsed, must be an integer");
        }
    }

    // Delete Stock
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

    public List<Stock> findAll() {
        return repository.findAll();
    }
}
