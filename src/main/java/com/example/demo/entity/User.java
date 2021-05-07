package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "Usuarios")
public class User implements Serializable {

	private static final long serialVersionUID = -1369148652554782331L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 50)
	private String name;
	private String lastname;
	@Column(name = "correo", nullable = false, unique = true, length = 50)
	private String email;
	private Boolean enabled;

}
