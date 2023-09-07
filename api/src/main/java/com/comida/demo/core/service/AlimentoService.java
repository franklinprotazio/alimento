package com.comida.demo.core.service;

import java.util.List;

import com.comida.demo.core.exception.AlimentoException;
import com.comida.demo.v1.dto.AlimentoDTO;

public interface AlimentoService {

	List<AlimentoDTO> getAlimentos();
	
	AlimentoDTO buscarAlimentoPorId(Long idAlimento) throws AlimentoException;

	AlimentoDTO salvarAlimento(AlimentoDTO alimentoDTO);

	AlimentoDTO AtualizarAlimento(Long idAlimento, AlimentoDTO alimentoDTO) throws AlimentoException;

	void deletarAlimento(Long idAlimento) throws AlimentoException;

}
