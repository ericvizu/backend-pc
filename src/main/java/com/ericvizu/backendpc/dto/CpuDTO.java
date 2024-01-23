package com.ericvizu.backendpc.dto;

public record CpuDTO(String brand, String name, String socket, Integer threads, Integer cores, Integer tdp) {
}
