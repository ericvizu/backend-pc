package com.ericvizu.backendpc.dto;

public record GpuDTO(String brand, String name, Integer baseClock, Integer boostClock, Integer vramSize, String vramGen, Integer tdp, Integer initialQuantity) {
}
