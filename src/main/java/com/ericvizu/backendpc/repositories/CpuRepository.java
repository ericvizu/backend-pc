package com.ericvizu.backendpc.repositories;

import com.ericvizu.backendpc.entities.Cpu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CpuRepository extends JpaRepository<Cpu, Long> {
}
