package com.ericvizu.backendpc.resources;

import com.ericvizu.backendpc.dto.RamDTO;
import com.ericvizu.backendpc.entities.Ram;
import com.ericvizu.backendpc.services.RamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(value = "/ram")
public class RamResource {

    @Autowired
    private RamService service;

    @PostMapping
    public ResponseEntity<Ram> create(@RequestBody RamDTO obj) {
        Ram newObj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).body(newObj);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Ram> read(@PathVariable Long id) {
        Ram obj = service.read(id);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Ram> update(@PathVariable Long id, @RequestBody RamDTO obj) {
        Ram entity = service.update(id, obj);
        return ResponseEntity.ok().body(entity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Ram> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Ram>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

}
