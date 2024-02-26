package com.ericvizu.backendpc.resources;

import com.ericvizu.backendpc.dto.GpuDTO;
import com.ericvizu.backendpc.entities.Gpu;
import com.ericvizu.backendpc.services.GpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(value = "/gpu")
public class GpuResource {

    @Autowired
    private GpuService service;

    @PostMapping
    public ResponseEntity<Gpu> create(@RequestBody GpuDTO obj) {
        Gpu newObj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).body(newObj);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Gpu> read(@PathVariable Long id) {
        Gpu obj = service.read(id);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Gpu> update(@PathVariable Long id, @RequestBody GpuDTO obj) {
        Gpu entity = service.update(id, obj);
        return ResponseEntity.ok().body(entity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Gpu> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Gpu>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

}
