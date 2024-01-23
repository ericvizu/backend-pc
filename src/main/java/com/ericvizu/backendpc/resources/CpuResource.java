package com.ericvizu.backendpc.resources;

import com.ericvizu.backendpc.dto.CpuDTO;
import com.ericvizu.backendpc.entities.Cpu;
import com.ericvizu.backendpc.services.CpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(value = "/cpu")
public class CpuResource {

    @Autowired
    private CpuService service;

    @PostMapping
    public ResponseEntity<Cpu> create(@RequestBody CpuDTO obj) {
        Cpu newObj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).body(newObj);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cpu> read(@PathVariable Long id) {
        Cpu obj = service.read(id);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Cpu> update(@PathVariable Long id, @RequestBody CpuDTO obj) {
        Cpu entity = service.update(id, obj);
        return ResponseEntity.ok().body(entity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Cpu> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Cpu>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

}
