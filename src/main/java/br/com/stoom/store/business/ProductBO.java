package br.com.stoom.store.business;

import br.com.stoom.store.business.exception.ProductNotFoundException;
import br.com.stoom.store.business.interfaces.IProductBO;
import br.com.stoom.store.model.Product;
import br.com.stoom.store.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductBO implements IProductBO {

	private final String errorMessage = "Product not found: ";
	
    @Autowired
    private ProductRepository repository;

    
	@Override
	public Product create(Product product) {
		product.setSku(skuGen(product));
		return this.repository.save(product);
	}

	@Override
	public List<Product> findAll(){
		return this.repository.findAll(isActive());
	}

	@Override
	public Product findById(Long id) throws ProductNotFoundException {
		return this.repository.findById(id).orElseThrow(() -> new ProductNotFoundException(errorMessage + id));
	}


	@Override
	public Product update(Long id, Product product) throws ProductNotFoundException {
		Product productToUpdate = this.repository.findById(id).orElseThrow(() -> new ProductNotFoundException(errorMessage + id));
		productToUpdate.setPrice(product.getPrice());
		productToUpdate.setName(product.getName());
		
		productToUpdate.setSku(skuGen(productToUpdate));
		
		return this.repository.save(productToUpdate);
	}


	@Override
	public Product changeStatus(Long id) throws ProductNotFoundException {
		Product product = repository.findById(id).orElseThrow(() -> new ProductNotFoundException(errorMessage + id));
		product.setActive(!product.isActive());
		
		return this.repository.save(product);
	}


	@Override
	public Product delete(Long id) throws ProductNotFoundException {
		Product product = repository.findById(id).orElseThrow(() -> new ProductNotFoundException(errorMessage + id));
		this.repository.delete(product);

		return product;
	}
	
	public String skuGen(Product product) {
		StringBuilder sku = new StringBuilder();
		
		sku.append(product.getName().substring(0, 3).toUpperCase() + "-");
		sku.append(product.getPrice().substring(0, 3).toUpperCase() + "-");
		sku.append(product.getPrice().substring(3).replace(".", ""));
		
		return sku.toString();
	}
	
    public Specification<Product> isActive() {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("active"), true);
    }
}