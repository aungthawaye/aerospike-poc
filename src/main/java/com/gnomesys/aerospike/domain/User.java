package com.gnomesys.aerospike.domain;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

	private static final long serialVersionUID = -5501678588492620694L;
	
	private String userId;
	private String email;
	private String name;
	private List<String> preferredHeroes;
	private Long createdDate;
	private Long updatedDate;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getPreferredHeroes() {
		return preferredHeroes;
	}

	public void setPreferredHeroes(List<String> preferredHeroes) {
		this.preferredHeroes = preferredHeroes;
	}

	public Long getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Long createdDate) {
		this.createdDate = createdDate;
	}

	public Long getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Long updatedDate) {
		this.updatedDate = updatedDate;
	}

}
