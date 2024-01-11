package com.ericvizu.backendpc.services;

import com.ericvizu.backendpc.repositories.MotherboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MotherboardService {

    @Autowired
    private MotherboardRepository repository;

}
