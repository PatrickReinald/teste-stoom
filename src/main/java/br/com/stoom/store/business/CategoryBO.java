package br.com.stoom.store.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stoom.store.business.interfaces.ICategoryBO;
import br.com.stoom.store.exception.ItemNotFoundException;
import br.com.stoom.store.model.Category;
import br.com.stoom.store.repository.CategoryRepository;

@Service
public class CategoryBO implements ICategoryBO {

private final String errorMessage = "Category not found: ";
	
	@Autowired
	private CategoryRepository repository;
	
	
	@Override
	public Category create(Category category) {
		return this.repository.save(category);
	}

	@Override
	public List<Category> findAll() {
		return this.repository.findAll();
	}

	@Override
	public Category findById(Long id) throws ItemNotFoundException  {
		return this.repository.findById(id).orElseThrow(() -> new ItemNotFoundException(errorMessage + id));
	}

	@Override
	public Category update(Long id, Category category) throws ItemNotFoundException {
		Category categoryToUpdate = this.repository.findById(id).orElseThrow(() -> new ItemNotFoundException(errorMessage + id));
		categoryToUpdate.setName(category.getName());
		
		return this.repository.save(categoryToUpdate);
	}

	@Override
	public Category changeStatus(Long id) throws ItemNotFoundException {
		Category category = this.repository.findById(id).orElseThrow(() -> new ItemNotFoundException(errorMessage + id));
		category.setActive(!category.isActive());
		
		return this.repository.save(category);
	}

	@Override
	public Category delete(Long id) throws ItemNotFoundException {
		Category category = this.repository.findById(id).orElseThrow(() -> new ItemNotFoundException(errorMessage + id));
		this.repository.delete(category);
		
		return category;
	}
}