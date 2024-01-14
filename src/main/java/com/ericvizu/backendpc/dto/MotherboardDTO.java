package com.ericvizu.backendpc.dto;

public record MotherboardDTO(String name, String socket, String ramGen, Integer ramSlots, Integer ramFreq, Integer sataSlots, Integer m2Gen4Slots, Integer m2Gen3Slots) {
}
