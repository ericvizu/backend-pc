package com.ericvizu.backendpc.resources;

import com.ericvizu.backendpc.services.MotherboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/motherboards")
public class MotherboardResource {

    @Autowired
    private MotherboardService service;

}
