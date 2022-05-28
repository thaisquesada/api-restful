package org.serratec.backend.projeto06.dto;

import java.io.Serializable;

public class ClientDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer clientId;
	private Integer cpf;
	private Integer phoneNum;
	private Integer email;
	
	public ClientDTO() {}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}