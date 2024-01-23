package br.com.stoom.store.business.interfaces;

import br.com.stoom.store.model.Product;

import java.util.List;

public interface IProductBO {

	Product create(Product product);
	
    List<Product> findAll();
    Product findById(Long id) throws Exception;
    
    Product update(Long id, Product product) throws Exception;
    
    Product changeStatus(Long id) throws Exception;
    Product delete(Long id) throws Exception;
}
