package com.ericvizu.backendpc.entities;

import com.ericvizu.backendpc.dto.MotherboardDTO;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_motherboard")
public class Motherboard implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand; // Mobo brand (ex. ASRock/Gigabyte)
    private String name; // Mobo name (ex. B550M Steel Legend/X570 Steel Legend)
    private String socket; // Mobo CPU socket (ex. AM4/AM5/LGA1155)
    private String ramGen; // Mobo RAM generation (ex. DDR3/DDR4/DDR5)
    private Integer ramSlots; // How many RAM slots in Mobo (ex. 2/4)
    private Integer ramFreq; // Ram frequency support in Mobo (in MHz) (ex. 3200/3600)
    private Integer sataSlots; // Assuming Sata3 version (ex. 6)
    private Integer m2Gen4Slots; // How many M.2 Gen4 slots in Mobo (ex. 0/1/2)
    private Integer m2Gen3Slots; // How many M.2 Gen3 Slots in Mobo (ex. 0/1/2)
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "stock_id", referencedColumnName = "id")
    @MapsId
    private Stock stock; // Must pass initialQuantity in body

    // Opcionais futuros: DirectX version; Pixel Shader version;

    public Motherboard() {
    }

    public Motherboard(MotherboardDTO motherboardDTO) {
        this.brand = motherboardDTO.brand();
        this.name = motherboardDTO.name();
        this.socket = motherboardDTO.socket();
        this.ramGen = motherboardDTO.ramGen();
        this.ramSlots = motherboardDTO.ramSlots();
        this.ramFreq = motherboardDTO.ramFreq();
        this.sataSlots = motherboardDTO.sataSlots();
        this.m2Gen4Slots = motherboardDTO.m2Gen4Slots();
        this.m2Gen3Slots = motherboardDTO.m2Gen3Slots();
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

    public String getRamGen() {
        return ramGen;
    }

    public void setRamGen(String ramGen) {
        this.ramGen = ramGen;
    }

    public Integer getRamSlots() {
        return ramSlots;
    }

    public void setRamSlots(Integer ramSlots) {
        this.ramSlots = ramSlots;
    }

    public Integer getRamFreq() {
        return ramFreq;
    }

    public void setRamFreq(Integer ramFreq) {
        this.ramFreq = ramFreq;
    }

    public Integer getSataSlots() {
        return sataSlots;
    }

    public void setSataSlots(Integer sataSlots) {
        this.sataSlots = sataSlots;
    }

    public Integer getM2Gen4Slots() {
        return m2Gen4Slots;
    }

    public void setM2Gen4Slots(Integer m2Gen4Slots) {
        this.m2Gen4Slots = m2Gen4Slots;
    }

    public Integer getM2Gen3Slots() {
        return m2Gen3Slots;
    }

    public void setM2Gen3Slots(Integer m2Gen3Slots) {
        this.m2Gen3Slots = m2Gen3Slots;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Motherboard that)) return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
