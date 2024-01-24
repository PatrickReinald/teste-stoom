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

import br.com.stoom.store.business.BrandBO;
import br.com.stoom.store.exception.ItemNotFoundException;
import br.com.stoom.store.model.Brand;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	private BrandBO service;
	
	
    @PostMapping
    public Brand create(@RequestBody Brand brand) {
    	return this.service.create(brand);
    }
    
    @GetMapping
    public List<Brand> findAll() {
        return this.service.findAll();
    }
    
    @GetMapping("/{id}")
    public Brand findById(@PathVariable Long id) throws ItemNotFoundException {
    	return this.service.findById(id);
    }
    
    @PutMapping("/{id}")
    public Brand update(@PathVariable Long id, @RequestBody Brand brand) throws ItemNotFoundException {
    	return this.service.update(id, brand);
    }
    
    @PutMapping("/toggle/{id}")
    public Brand changeStatus(@PathVariable Long id) throws ItemNotFoundException {
    	return this.service.changeStatus(id);
    }
    
    @DeleteMapping("/{id}")
    public Brand delete(@PathVariable Long id) throws ItemNotFoundException {
    	return this.service.delete(id);
    }
	
}
