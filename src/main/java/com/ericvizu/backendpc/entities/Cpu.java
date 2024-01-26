package com.ericvizu.backendpc.entities;

import com.ericvizu.backendpc.dto.CpuDTO;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_cpu")
public class Cpu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String name;
    private String socket;
    private Integer cores;
    private Integer threads;
    private Integer tdp;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "stock_id", referencedColumnName = "id")
    @MapsId
    private Stock stock;

    // baseClock, overClock, Cache

    public Cpu() {
    }

    public Cpu(CpuDTO CpuDTO) {
        this.brand = CpuDTO.brand();
        this.name = CpuDTO.name();
        this.socket = CpuDTO.socket();
        this.cores = CpuDTO.cores();
        this.threads = CpuDTO.threads();
        this.tdp = CpuDTO.tdp();
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public Integer getCores() {
        return cores;
    }

    public void setCores(Integer cores) {
        this.cores = cores;
    }

    public Integer getThreads() {
        return threads;
    }

    public void setThreads(Integer threads) {
        this.threads = threads;
    }

    public Integer getTdp() {
        return tdp;
    }

    public void setTdp(Integer tdp) {
        this.tdp = tdp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cpu cpu)) return false;

        return getId().equals(cpu.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
