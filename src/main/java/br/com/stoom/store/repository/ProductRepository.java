package br.com.stoom.store.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.stoom.store.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query(nativeQuery = true, value = "SELECT * FROM Product p WHERE p.id = ?1")
	Optional<Product> findById(Long id);
}