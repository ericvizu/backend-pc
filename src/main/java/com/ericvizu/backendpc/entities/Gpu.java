package com.ericvizu.backendpc.entities;

import com.ericvizu.backendpc.dto.GpuDTO;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_gpu")
public class Gpu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand; // GPU brand (ex. AMD Radeon/Nvidia GeForce)
    private String name; // GPU name (ex. RX 580/GTX 960)
    private Integer baseClock; // GPU base clock (in MHz) (ex. 1257/1127)
    private Integer boostClock; // GPU boosted clock (in MHz) (ex. 1340/1178)
    private Integer vramSize; // GPU VRAM size (in gb) (ex. 8/2)
    private String vramGen; // GPU VRAM generation (ex. GGDR5/GDDR4)
    private Integer tdp; // GPU TDP/TBP (in Watts) (ex. 185/120)

    // Future ideas: supported rendering format (h264/h265/hevc), outputs (hdmi, dvi, displayport)

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "stock_id", referencedColumnName = "id")
    @MapsId
    private Stock stock; // Must pass initialQuantity in body

    public Gpu() {
    }

    public Gpu(GpuDTO GpuDTO) {
        this.brand = GpuDTO.brand();
        this.name = GpuDTO.name();
        this.baseClock = GpuDTO.baseClock();
        this.boostClock = GpuDTO.boostClock();
        this.vramSize = GpuDTO.vramSize();
        this.vramGen = GpuDTO.vramGen();
        this.tdp = GpuDTO.tdp();
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

    public Integer getBaseClock() {
        return baseClock;
    }

    public void setBaseClock(Integer baseClock) {
        this.baseClock = baseClock;
    }

    public Integer getBoostClock() {
        return boostClock;
    }

    public void setBoostClock(Integer boostClock) {
        this.boostClock = boostClock;
    }

    public Integer getVramSize() {
        return vramSize;
    }

    public void setVramSize(Integer vramSize) {
        this.vramSize = vramSize;
    }

    public String getVramGen() {
        return vramGen;
    }

    public void setVramGen(String vramGen) {
        this.vramGen = vramGen;
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
        if (!(o instanceof Gpu gpu)) return false;

        return getId().equals(gpu.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
