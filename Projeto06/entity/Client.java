package org.serratec.backend.projeto06.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="client_id")
	private Integer clientId;
	
	@Column(name="client_cpf")
	private Integer cpf;
	
	@Column(name="client_phone")
	private Integer phoneNum;

	@Column(name="client_email")
	private Integer email;
	
	public Client() {}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public Integer getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(Integer phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Integer getEmail() {
		return email;
	}

	public void setEmail(Integer email) {
		this.email = email;
	}
	
}
