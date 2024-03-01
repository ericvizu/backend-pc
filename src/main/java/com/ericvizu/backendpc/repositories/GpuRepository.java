package com.ericvizu.backendpc.repositories;

import com.ericvizu.backendpc.entities.Gpu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GpuRepository extends JpaRepository<Gpu, Long> {
}
