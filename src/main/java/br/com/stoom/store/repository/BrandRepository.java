package br.com.stoom.store.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.stoom.store.model.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM Brand b WHERE b.id = ?1")
	Optional<Brand> findById(Long id);
}
