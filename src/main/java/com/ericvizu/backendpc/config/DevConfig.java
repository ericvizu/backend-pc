package com.ericvizu.backendpc.config;

import com.ericvizu.backendpc.entities.Motherboard;
import com.ericvizu.backendpc.repositories.MotherboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig implements CommandLineRunner {
    @Autowired
    private MotherboardRepository motherboardRepository;

    @Override
    public void run(String... args) throws Exception {
        Motherboard mobo = new Motherboard(1L, "ASRock B500M Steel Legend", "AM4", "DDR4", 4, 3600, 6, 1, 1);
        motherboardRepository.save(mobo);

    }
}
