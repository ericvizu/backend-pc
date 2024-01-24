package com.ericvizu.backendpc.entities;

import com.ericvizu.backendpc.dto.MotherboardDTO;
import com.ericvizu.backendpc.dto.StockDTO;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_stock")
public class Stock implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category; // Motherboard, CPU, GPU, etc.
    private Integer itemId; // Id in each category table
    private Integer quantity; // Quantity in stock
    public Stock() {
    }

    public Stock(StockDTO stockDTO) {
        this.category = stockDTO.category();
        this.itemId = stockDTO.itemId();
        this.quantity = stockDTO.quantity();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stock stock)) return false;

        return getId().equals(stock.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
