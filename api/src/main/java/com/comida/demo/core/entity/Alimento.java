package com.comida.demo.core.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ALIMENTO")
public class Alimento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_alimento")
	private Long idAlimento;
	
	@Column(name = "nome_alimento")
	private String nome;
	
	@Column(name = "tipo_alimento")
	private String tipoAlimento;

}
