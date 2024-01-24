package br.com.stoom.store.business.interfaces;

import java.util.List;

import br.com.stoom.store.exception.ItemNotFoundException;
import br.com.stoom.store.model.Product;

public interface IProductBO {

	Product create(Product product);
	
    List<Product> findAll();
    Product findById(Long id) throws ItemNotFoundException;
    
    Product update(Long id, Product product) throws ItemNotFoundException;
    Product changeStatus(Long id) throws ItemNotFoundException;
    
	Product delete(Long id) throws ItemNotFoundException;

}
