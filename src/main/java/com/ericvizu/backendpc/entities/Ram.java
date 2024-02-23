package com.ericvizu.backendpc.entities;

import com.ericvizu.backendpc.dto.RamDTO;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_ram")
public class Ram implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand; // RAM brand (ex. Kingston/Husky)
    private String name; // RAM name (ex. [Kingston] Fury/[Husky] Gaming Avalanche)
    private String gen; // RAM socket (ex. DDR4/DDR5)
    private String freq; // RAM frequency (in MHz) (ex. 3600/3200)
    private String latency; // RAM latency (CL16/CL18)
//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "stock_id", referencedColumnName = "id")
//    @MapsId
//    private Stock stock; // Must pass initialQuantity in body

    // Opcionais futuros: DirectX version; Pixel Shader version;

    public Ram() {
    }

    public Ram(RamDTO ramDTO) {
        this.brand = ramDTO.brand();
        this.name = ramDTO.name();
        this.gen = ramDTO.gen();
        this.freq = ramDTO.freq();
        this.latency = ramDTO.latency();
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

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getFreq() {
        return freq;
    }

    public void setFreq(String freq) {
        this.freq = freq;
    }

    public String getLatency() {
        return latency;
    }

    public void setLatency(String latency) {
        this.latency = latency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ram that)) return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
