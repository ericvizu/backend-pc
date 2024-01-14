package com.ericvizu.backendpc.resources;

import com.ericvizu.backendpc.dto.MotherboardDTO;
import com.ericvizu.backendpc.entities.Motherboard;
import com.ericvizu.backendpc.services.MotherboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/motherboard")
public class MotherboardResource {

    @Autowired
    private MotherboardService service;

    @PostMapping
    public ResponseEntity<Motherboard> create(@RequestBody MotherboardDTO obj) {
        Motherboard newObj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).body(newObj);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Motherboard> read(@PathVariable Long id) {
        Motherboard obj = service.read(id);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Motherboard> update(@PathVariable Long id, @RequestBody MotherboardDTO obj) {
        Motherboard entity = service.update(id, obj);
        return ResponseEntity.ok().body(entity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Motherboard> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
