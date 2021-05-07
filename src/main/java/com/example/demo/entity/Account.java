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
	private String tipoCuenta;
	private String user;
}
