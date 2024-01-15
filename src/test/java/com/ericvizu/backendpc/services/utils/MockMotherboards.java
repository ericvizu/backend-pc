package com.ericvizu.backendpc.services.utils;

import com.ericvizu.backendpc.dto.MotherboardDTO;
import com.ericvizu.backendpc.entities.Motherboard;

import java.util.ArrayList;
import java.util.List;

public class MockMotherboards {

    public static String NAME = "nome de teste";
    public static String SOCKET = "socket de teste";
    public static String RAMGEN = "ramGen de teste";
    public static Integer RAMSLOTS = 0;
    public static Integer RAMFREQ = 0;
    public static Integer SATASLOTS = 0;
    public static Integer M2GEN4SLOTS = 0;
    public static Integer M2GEN3SLOTS = 0;

    public static MotherboardDTO mockMotherboardDTO() {
        return new MotherboardDTO(NAME, SOCKET, RAMGEN, RAMSLOTS, RAMFREQ, SATASLOTS, M2GEN4SLOTS, M2GEN3SLOTS);
    }

    public static Motherboard mockMotherboardEntity() {
        return new Motherboard(mockMotherboardDTO());
    }
    public static List<Motherboard> mockMotherboardList() {
        Motherboard motherboard = mockMotherboardEntity();
        List<Motherboard> listMotherboards = new ArrayList<>();
        listMotherboards.add(motherboard);
        return listMotherboards;
    }
}
