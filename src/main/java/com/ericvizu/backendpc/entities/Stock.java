package com.ericvizu.backendpc.entities;

import com.ericvizu.backendpc.dto.StockDTO;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_stock")
public class Stock implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category; // (ex. motherboard/gpu/cpu/...)
    private Integer quantity; // Quantity in stock (POST from categories have initialQuantity)
    private String name; // Name of item (not Brand)

    public Stock() {
    }

    public Stock(StockDTO stockDTO) {
        this.category = stockDTO.category();
        this.quantity = stockDTO.quantity();
        this.name = stockDTO.name();
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
