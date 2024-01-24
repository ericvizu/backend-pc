package com.ericvizu.backendpc.services;

import com.ericvizu.backendpc.dto.StockDTO;
import com.ericvizu.backendpc.entities.Stock;
import com.ericvizu.backendpc.repositories.StockRepository;
import com.ericvizu.backendpc.services.exceptions.DatabaseException;
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

    // Create new item in Stock from other categories
    public Stock create(StockDTO obj, String category, Integer quantity) {
        Stock stock = new Stock(obj);
        stock.setCategory(category);
        stock.setQuantity(quantity);
        return repository.save(stock);
    }

    // Read Stock with Category and Id from the tb_[category]
    public Stock read(String category, Long id) {
        try {
            if (category.equals("motherboard") || category.equals("cpu")) {
                Optional<Stock> obj = repository.findById(id);
                return obj.orElseThrow(() -> new ResourceNotFoundException(id));
            } throw new RuntimeException("Category not valid.");
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Missing id number.");
        }

    }

    // Update Stock
    public Stock update(Long id, StockDTO obj) {
        try {
            Stock entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
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

    // Update each Stock entry
    // Method has to be updated if entity gets new parameters
    public void updateData(Stock entity, StockDTO obj) {
        if (!(obj.category() == null)) entity.setCategory(obj.category());
        if (!(obj.itemId() == null)) entity.setItemId(obj.itemId());
        if (!(obj.quantity() == null)) entity.setQuantity(obj.quantity());
    }

}
