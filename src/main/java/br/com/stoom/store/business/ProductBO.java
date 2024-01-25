package br.com.stoom.store.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stoom.store.business.interfaces.IProductBO;
import br.com.stoom.store.exception.ItemNotFoundException;
import br.com.stoom.store.model.Product;
import br.com.stoom.store.repository.ProductRepository;


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
		return this.repository.findAll();
	}

	@Override
	public Product findById(Long id) throws ItemNotFoundException {
		return this.repository.findById(id).orElseThrow(() -> new ItemNotFoundException(errorMessage + id));
	}


	@Override
	public Product update(Long id, Product product) throws ItemNotFoundException {
		Product productToUpdate = this.repository.findById(id).orElseThrow(() -> new ItemNotFoundException(errorMessage + id));
		productToUpdate.setPrice(product.getPrice());
		productToUpdate.setName(product.getName());
		
		productToUpdate.setSku(skuGen(productToUpdate));
		
		return this.repository.save(productToUpdate);
	}


	@Override
	public Product changeStatus(Long id) throws ItemNotFoundException {
		Product product = repository.findById(id).orElseThrow(() -> new ItemNotFoundException(errorMessage + id));
		product.setActive(!product.isActive());
		
		return this.repository.save(product);
	}


	@Override
	public Product delete(Long id) throws ItemNotFoundException {
		Product product = this.repository.findById(id).orElseThrow(() -> new ItemNotFoundException(errorMessage + id));
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
}