package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Cuentas")
public class Account implements Serializable{
	
	private static final long serialVersionUID = -484291580637756494L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long saldo;
	private String user;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSaldo() {
		return saldo;
	}
	public void setSaldo(Long saldo) {
		this.saldo = saldo;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
}
