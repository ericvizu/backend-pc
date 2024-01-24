package com.ericvizu.backendpc.resources;

import com.ericvizu.backendpc.dto.StockDTO;
import com.ericvizu.backendpc.entities.Stock;
import com.ericvizu.backendpc.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(value = "/stock")
public class StockResource {

    @Autowired
    private StockService service;

//    @PostMapping
//    public ResponseEntity<Stock> create(@RequestBody StockDTO obj, @RequestBody String category) {
//        Stock newObj = service.create(obj, category);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
//        return ResponseEntity.created(uri).body(newObj);
//    }

//    @GetMapping(value = "/{id}")
//    public ResponseEntity<Stock> read(@PathVariable Long id) {
//        Stock obj = service.read(id);
//        return ResponseEntity.ok().body(obj);
//    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Stock> update(@PathVariable Long id, @RequestBody StockDTO obj) {
        Stock entity = service.update(id, obj);
        return ResponseEntity.ok().body(entity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Stock> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Stock>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

}
