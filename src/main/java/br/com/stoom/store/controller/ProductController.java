package br.com.stoom.store.controller;

import java.util.Set;
import java.util.stream.Collectors;

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
import br.com.stoom.store.dto.ProductDto;
import br.com.stoom.store.exception.ItemNotFoundException;
import br.com.stoom.store.model.Product;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductBO service;

    
    @PostMapping
    public ProductDto create(@RequestBody Product product) {
    	return ProductDto.transmute(this.service.create(product));
    }
    
    @GetMapping
    public Set<ProductDto> findAll() {
        return this.service.findAll().stream().map(ProductDto::transmute).collect(Collectors.toSet());
    }
    
    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) throws ItemNotFoundException {
    	return ProductDto.transmute(this.service.findById(id));
    }
    
    @GetMapping("/sku/{sku}")
    public ProductDto findBySku(@PathVariable String sku) throws ItemNotFoundException {
    	return ProductDto.transmute(this.service.findBySku(sku));
    }
    
    @PutMapping("/{id}")
    public ProductDto update(@PathVariable Long id, @RequestBody Product product) throws ItemNotFoundException {
    	return ProductDto.transmute(this.service.update(id, product));
    }
    
    @PutMapping("/toggle/{id}")
    public ProductDto changeStatus(@PathVariable Long id) throws ItemNotFoundException {
    	return ProductDto.transmute(this.service.changeStatus(id));
    }
    
    @DeleteMapping("/{id}")
    public ProductDto delete(@PathVariable Long id) throws ItemNotFoundException {
    	return ProductDto.transmute(this.service.delete(id));
    }
}