package br.com.stoom.store.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "product")
public class Product implements Serializable {
	
	private static final long serialVersionUID = -7044993010477700469L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    @SequenceGenerator(name = "product_sequence", sequenceName = "PRODUCT_SEQ")
    @Column(name = "id")
    private Long id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "sku", unique = true)
	private String sku;
    
    @Column(name = "price")
    private String price;
    
    @CreationTimestamp
    @Column(name = "create_date")
    private LocalDateTime created;
    
    @UpdateTimestamp
    @Column(name = "modify_date")
    private LocalDateTime modified;
    
    @Column(name = "active")
    private boolean active = Boolean.TRUE;
    
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
    
    
	public Product() {
		super();
	}	

	public Product(Long id) {
		super();
		this.id = id;
	}

	public Product(String name, String price, Brand brand) {
		super();
		this.name = name;
		this.price = price;
		this.brand = brand;
	}
	
	public Product(Long id, String name, String sku, String price, LocalDateTime created, LocalDateTime modified,
			boolean active, Brand brand) {
		super();
		this.id = id;
		this.name = name;
		this.sku = sku;
		this.price = price;
		this.created = created;
		this.modified = modified;
		this.active = active;
		this.brand = brand;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
}