package br.com.stoom.store.business.interfaces;

import java.util.List;

import br.com.stoom.store.model.Brand;

public interface IBrandBO {

	Brand create(Brand brand);
	
    List<Brand> findAll();
    Brand findById(Long id) throws Exception;
    
    Brand update(Long id, Brand brand) throws Exception;
    Brand changeStatus(Long id) throws Exception;
    
    Brand delete(Long id) throws Exception;
}
