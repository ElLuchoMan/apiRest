package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "Usuario")
public class User implements Serializable {

	private static final long serialVersionUID = -1369148652554782331L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long usuarioId;
	@Column(length = 50)
	private String name;
	private String lastname;
	@Column(name = "correo", nullable = false, unique = true, length = 80)
	private String email;
	private Boolean enabled;

	public Long getId() {
		return usuarioId;
	}

	public void setId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

}
