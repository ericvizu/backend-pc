package com.ericvizu.backendpc.repositories;

import com.ericvizu.backendpc.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
