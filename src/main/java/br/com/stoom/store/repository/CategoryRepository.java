package br.com.stoom.store.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.stoom.store.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM Category c WHERE c.id = ?1")
	Optional<Category> findById(Long id);
}
