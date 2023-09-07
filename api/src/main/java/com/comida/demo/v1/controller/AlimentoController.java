package com.comida.demo.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comida.demo.core.exception.AlimentoException;
import com.comida.demo.core.service.AlimentoService;
import com.comida.demo.integration.repositoty.AlimentoRepository;
import com.comida.demo.v1.dto.AlimentoDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/v1/alimento")
public class AlimentoController {

	private static final String MENSAGEM_ALIMENTO_INEXISTENTE = "Não foram encontradas alimento com o id = ";

	@Autowired
	AlimentoRepository alimentoRepository;

	@Autowired
	AlimentoService alimentoService;

	@GetMapping
	public ResponseEntity<Object> getAlimentos() {

		List<AlimentoDTO> listaAlimentosDTO = alimentoService.getAlimentos();

		if (!listaAlimentosDTO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(listaAlimentosDTO);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foram encontrados alimentos na base de dados");
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> buscarAlimentosPorId(@PathVariable(value = "id") @Valid Long idAlimento)
			throws AlimentoException {

		AlimentoDTO alimentoDTO;
		try {

			alimentoDTO = alimentoService.buscarAlimentoPorId(idAlimento);

			if (alimentoDTO != null && alimentoDTO.getIdAlimento() != null) {

			}

		} catch (AlimentoException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(MENSAGEM_ALIMENTO_INEXISTENTE + idAlimento);
		}

		return ResponseEntity.status(HttpStatus.OK).body(alimentoDTO);
	}

	@PostMapping
	public ResponseEntity<AlimentoDTO> salvarAlimento(@RequestBody @Valid AlimentoDTO alimentoDTO) {

		return ResponseEntity.status(HttpStatus.OK).body(alimentoService.salvarAlimento(alimentoDTO));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> atualizarAlimento(@RequestBody @Valid AlimentoDTO alimentoDTO,
			@PathVariable(value = "id") Long idAlimento) {

		AlimentoDTO alimentoRetornoDTO;

		try {
			alimentoRetornoDTO = alimentoService.AtualizarAlimento(idAlimento, alimentoDTO);

			if (alimentoRetornoDTO != null && alimentoRetornoDTO.getIdAlimento() != null) {

			}
		} catch (AlimentoException e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(MENSAGEM_ALIMENTO_INEXISTENTE + idAlimento);

		}
		return ResponseEntity.status(HttpStatus.OK).body(alimentoRetornoDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletarAlimentos(@PathVariable(value = "id") @Valid Long idAlimento)
			throws AlimentoException {

		AlimentoDTO alimentoDTO;

		try {
			alimentoDTO = alimentoService.buscarAlimentoPorId(idAlimento);

			if (alimentoDTO != null && alimentoDTO.getIdAlimento() != null) {
				alimentoService.deletarAlimento(idAlimento);

			} else {

			}
		} catch (AlimentoException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(MENSAGEM_ALIMENTO_INEXISTENTE + idAlimento);

		}
		return ResponseEntity.status(HttpStatus.OK).body("Alimento deletado com sucesso");
	}

}
