package com.ericvizu.backendpc.resources;

import com.ericvizu.backendpc.entities.Stock;
import com.ericvizu.backendpc.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(value = "/stock")
public class StockResource {

    @Autowired
    private StockService service;
    // POST: Talvez não colocar
//    @PostMapping
//    public ResponseEntity<Stock> create(@RequestBody StockDTO obj, @RequestBody String category) {
//        Stock newObj = service.create(obj, category);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
//        return ResponseEntity.created(uri).body(newObj);
//    }

    // Se acabar usando livraria pra mexer com Json (como JsonPath), dá usar Json pra passar a category usando JSONObject e getString()
    @GetMapping(value = "/{id}")
    public ResponseEntity<Stock> read(@PathVariable Long id) {
        Stock obj = service.read(id);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Stock> update(@PathVariable Long id, @RequestBody String quantity) {
        Stock entity = service.update(id, quantity);
        return ResponseEntity.ok().body(entity);
    }

    // DELETE: Talvez não colocar, ou só pra developer pra bugfix pra caso exclua algum item em outra table e aqui não
//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<Stock> delete(@PathVariable Long id) {
//        service.delete(id);
//        return ResponseEntity.noContent().build();
//    }

    // TODO FINDALL: Adicionar o nome do item que tá contando no id
    @GetMapping
    public ResponseEntity<List<Stock>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

}
