package com.ericvizu.backendpc.repositories;

import com.ericvizu.backendpc.entities.Motherboard;
import com.ericvizu.backendpc.entities.Ram;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RamRepository extends JpaRepository<Ram, Long> {
}
