package org.serratec.backend.projeto06.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="service")
public class Service {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="service_id")
	Integer id;
	
	@Column(name="price", nullable = false)
    private String price;

    @Column(name = "service", nullable = false)
    private String service;

    @Column(name="data", nullable = false)
    private Date data;
    
    public Service() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
}
