package br.com.stoom.store.dto;

import java.time.LocalDateTime;

import br.com.stoom.store.model.Product;


public class ProductDto {

	private Long id;

	private String name;
	
	private String sku;
    
    private String price;
    
    private LocalDateTime created;
    
    private LocalDateTime modified;
    
    private boolean active = Boolean.TRUE;
    
    private BrandDto brand;
    
    private CategoryDto category;

	public ProductDto(Long id, String name, String sku, String price, LocalDateTime created, LocalDateTime modified,
			boolean active, BrandDto brand, CategoryDto category) {
		super();
		this.id = id;
		this.name = name;
		this.sku = sku;
		this.price = price;
		this.created = created;
		this.modified = modified;
		this.active = active;
		this.brand = brand;
		this.category = category;
	}
	
	public static ProductDto transmute(Product product) {
		return new ProductDto(product.getId(),
				product.getName(),
				product.getSku(),
				product.getPrice(),
				product.getCreated(),
				product.getModified(),
				product.isActive(),
				BrandDto.transmute(product.getBrand()),
				CategoryDto.transmute(product.getCategory()));
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

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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

	public BrandDto getBrand() {
		return brand;
	}

	public void setBrand(BrandDto brand) {
		this.brand = brand;
	}

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}
}