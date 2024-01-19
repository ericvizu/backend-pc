package com.ericvizu.backendpc.services;

import com.ericvizu.backendpc.entities.Motherboard;
import com.ericvizu.backendpc.repositories.MotherboardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.ericvizu.backendpc.services.utils.MockMotherboards.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


class MotherboardServiceTest {

    @Mock
    MotherboardRepository motherboardRepository;

    @InjectMocks
    @Autowired
    MotherboardService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void create() {
    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    @DisplayName("Should return a Motherboard List on findAll")
    void findAllSuccess() {
        when(motherboardRepository.findAll()).thenReturn(mockMotherboardList());

        List<Motherboard> result = this.service.findAll();

        assertNotNull(result);
        assertEquals(result.get(0).getName(), NAME);
        assertEquals(result.get(0).getSocket(), SOCKET);
        assertEquals(result.get(0).getRamGen(), RAMGEN);
        assertEquals(result.get(0).getRamSlots(), RAMSLOTS);
        assertEquals(result.get(0).getRamFreq(), RAMFREQ);
        assertEquals(result.get(0).getSataSlots(), SATASLOTS);
        assertEquals(result.get(0).getM2Gen4Slots(), M2GEN4SLOTS);
        assertEquals(result.get(0).getM2Gen3Slots(), M2GEN3SLOTS);
    }
}