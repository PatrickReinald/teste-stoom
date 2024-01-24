package br.com.stoom.store.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "category")
public class Category implements Serializable {

	private static final long serialVersionUID = 5732687855916107339L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    @SequenceGenerator(name = "product_sequence", sequenceName = "PRODUCT_SEQ")
    @Column(name = "id")
    private Long id;
	
	@Column(name = "name", unique = true)
	private String name;
	
    @CreationTimestamp
    @Column(name = "create_date")
    private LocalDateTime created;
    
    @UpdateTimestamp
    @Column(name = "modify_date")
    private LocalDateTime modified;
    
    @Column(name = "active")
    private boolean active = Boolean.TRUE;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private Set<Product> products;

    
	public Category() {
		super();
	}

	public Category(Long id) {
		super();
		this.id = id;
	}

	public Category(String name) {
		super();
		this.name = name;
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

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
}