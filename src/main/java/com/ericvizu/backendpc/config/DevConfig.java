package com.ericvizu.backendpc.config;

import com.ericvizu.backendpc.repositories.CpuRepository;
import com.ericvizu.backendpc.repositories.GpuRepository;
import com.ericvizu.backendpc.repositories.MotherboardRepository;
import com.ericvizu.backendpc.repositories.RamRepository;
import com.ericvizu.backendpc.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

//@Configuration
//@Profile("dev")
public class DevConfig implements CommandLineRunner {
    @Autowired
    private MotherboardRepository motherboardRepository;
    @Autowired
    private CpuRepository cpuRepository;
    @Autowired
    private GpuRepository gpuRepository;
    @Autowired
    private RamRepository ramRepository;
    @Autowired
    private StockRepository stockRepository;

    @Override
    public void run(String... args) throws Exception {
    }
}
