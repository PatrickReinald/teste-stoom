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
import org.hibernate.annotations.Where;

@Entity
@Table(name = "brand")
@Where(clause = "active=true")
public class Brand implements Serializable {

	private static final long serialVersionUID = -3476967889285481742L;
	
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

    @OneToMany(mappedBy = "brand", fetch = FetchType.EAGER)
    private Set<Product> products;
    
    
	public Brand() {
		super();
	}
	
	public Brand(Long id) {
		super();
		this.id = id;
	}

	public Brand(String name) {
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