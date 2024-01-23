package br.com.stoom.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.stoom.store.business.ProductBO;
import br.com.stoom.store.business.exception.ProductNotFoundException;
import br.com.stoom.store.model.Product;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductBO service;

    @PostMapping
    public Product create(@RequestBody Product product) {
    	return this.service.create(product);
    }
    
    /*@GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> p = this.service.findAll();
        if(!p.isEmpty())
            return new ResponseEntity<>(p, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }*/
    
    @GetMapping
    public List<Product> findAll() {
        return this.service.findAll();
    }
    
    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) throws ProductNotFoundException {
    	return this.service.findById(id);
    }
    
    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) throws ProductNotFoundException {
    	return this.service.update(id, product);
    }
    
    @PutMapping("/toggle/{id}")
    public Product changeStatus(@PathVariable Long id) throws ProductNotFoundException {
    	return this.service.changeStatus(id);
    }
    
    @DeleteMapping("/{id}")
    public Product delete(@PathVariable Long id) throws ProductNotFoundException {
    	return this.service.delete(id);
    }
}