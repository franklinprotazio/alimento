package com.comida.demo.v1.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlimentoDTO {

	private Long idAlimento;

	@NotBlank
	private String nome;

	private String tipoAlimento;

}
