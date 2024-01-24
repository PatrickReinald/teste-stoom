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

import br.com.stoom.store.business.CategoryBO;
import br.com.stoom.store.exception.ItemNotFoundException;
import br.com.stoom.store.model.Category;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryBO service;
	
	
    @PostMapping
    public Category create(@RequestBody Category category) {
    	return this.service.create(category);
    }
    
    @GetMapping
    public List<Category> findAll() {
        return this.service.findAll();
    }
    
    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id) throws ItemNotFoundException {
    	return this.service.findById(id);
    }
    
    @PutMapping("/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category category) throws ItemNotFoundException {
    	return this.service.update(id, category);
    }
    
    @PutMapping("/toggle/{id}")
    public Category changeStatus(@PathVariable Long id) throws ItemNotFoundException {
    	return this.service.changeStatus(id);
    }
    
    @DeleteMapping("/{id}")
    public Category delete(@PathVariable Long id) throws ItemNotFoundException {
    	return this.service.delete(id);
    }
}