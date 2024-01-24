package br.com.stoom.store.business.interfaces;

import java.util.List;

import br.com.stoom.store.model.Category;


public interface ICategoryBO {

	Category create(Category category);
	
    List<Category> findAll();
    Category findById(Long id) throws Exception;
    
    Category update(Long id, Category category) throws Exception;
    Category changeStatus(Long id) throws Exception;
    
    Category delete(Long id) throws Exception;
}