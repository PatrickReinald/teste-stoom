package br.com.stoom.store.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.stoom.store.business.interfaces.IBrandBO;
import br.com.stoom.store.exception.ItemNotFoundException;
import br.com.stoom.store.model.Brand;
import br.com.stoom.store.repository.BrandRepository;

@Service
public class BrandBO implements IBrandBO {

	private final String errorMessage = "Brand not found: ";
	
	@Autowired
	private BrandRepository repository;
	
	
	@Override
	public Brand create(Brand brand) {
		return this.repository.save(brand);
	}

	@Override
	public List<Brand> findAll() {
		return this.repository.findAll(isActive());
	}

	@Override
	public Brand findById(Long id) throws ItemNotFoundException  {
		return this.repository.findById(id).orElseThrow(() -> new ItemNotFoundException(errorMessage + id));
	}

	@Override
	public Brand update(Long id, Brand brand) throws ItemNotFoundException {
		Brand brandToUpdate = this.repository.findById(id).orElseThrow(() -> new ItemNotFoundException(errorMessage + id));
		brandToUpdate.setName(brand.getName());
		
		return this.repository.save(brandToUpdate);
	}

	@Override
	public Brand changeStatus(Long id) throws ItemNotFoundException {
		Brand brand = this.repository.findById(id).orElseThrow(() -> new ItemNotFoundException(errorMessage + id));
		brand.setActive(!brand.isActive());
		
		return this.repository.save(brand);
	}

	@Override
	public Brand delete(Long id) throws ItemNotFoundException {
		Brand brand = this.repository.findById(id).orElseThrow(() -> new ItemNotFoundException(errorMessage + id));
		this.repository.delete(brand);
		
		return brand;
	}

	public Specification<Brand> isActive() {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("active"), true);
    }
}
