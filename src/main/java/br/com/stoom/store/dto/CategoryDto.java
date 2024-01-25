package br.com.stoom.store.dto;

import java.time.LocalDateTime;
import java.util.Set;

import br.com.stoom.store.model.Category;

public class CategoryDto {

 	private Long id;
	
	private String name;
	
    private LocalDateTime created;
    
    private LocalDateTime modified;
    
    private boolean active = Boolean.TRUE;

    private Set<ProductDto> products;

	public CategoryDto(Long id, String name, LocalDateTime created, LocalDateTime modified, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.created = created;
		this.modified = modified;
		this.active = active;
	}

	public static CategoryDto transmute(Category category) {
		return new CategoryDto(category.getId(), 
				category.getName(), 
				category.getCreated(), 
				category.getModified(), 
				category.isActive()); 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Set<ProductDto> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductDto> products) {
		this.products = products;
	}
}