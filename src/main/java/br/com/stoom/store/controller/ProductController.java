package br.com.stoom.store.controller;

import br.com.stoom.store.business.ProductBO;
import br.com.stoom.store.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}