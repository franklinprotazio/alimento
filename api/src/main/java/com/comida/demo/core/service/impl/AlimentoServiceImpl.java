package com.comida.demo.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comida.demo.core.entity.Alimento;
import com.comida.demo.core.exception.AlimentoException;
import com.comida.demo.core.service.AlimentoService;
import com.comida.demo.integration.repositoty.AlimentoRepository;
import com.comida.demo.v1.dto.AlimentoDTO;

@Service
public class AlimentoServiceImpl implements AlimentoService {

	private static final String MENSAGEM_ALIMENTO_INEXISTENTE = "Não foram encontradas alimento com o id = ";

	@Autowired
	private AlimentoRepository alimentoRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<AlimentoDTO> getAlimentos() {

		List<Alimento> alimentos = alimentoRepository.findAll();
		List<AlimentoDTO> alimentosRetorno = new ArrayList<>();

		if (!alimentos.isEmpty()) {
			for (Alimento alimento : alimentos) {
				AlimentoDTO alimentoDTO = modelMapper.map(alimento, AlimentoDTO.class);
				alimentosRetorno.add(alimentoDTO);
			}
		}

		return alimentosRetorno;
	}

	@Override
	public AlimentoDTO buscarAlimentoPorId(Long idAlimento) throws AlimentoException {
		Alimento alimento = alimentoRepository.findById(idAlimento)
				.orElseThrow(() -> new AlimentoException(MENSAGEM_ALIMENTO_INEXISTENTE + idAlimento));

		AlimentoDTO alimentoDTO = modelMapper.map(alimento, AlimentoDTO.class);

		return alimentoDTO;
	}

	@Override
	public AlimentoDTO salvarAlimento(AlimentoDTO alimentoDTO) {
		Alimento alimento = modelMapper.map(alimentoDTO, Alimento.class);
		AlimentoDTO alimentoRetornoDTO = modelMapper.map(alimentoRepository.save(alimento), AlimentoDTO.class);

		return alimentoRetornoDTO;
	}

	@Override
	public AlimentoDTO AtualizarAlimento(Long idAlimento, AlimentoDTO alimentoDTO) throws AlimentoException {

		Alimento alimento = alimentoRepository.findById(idAlimento)
				.orElseThrow(() -> new AlimentoException(MENSAGEM_ALIMENTO_INEXISTENTE + idAlimento));

		alimento.setNome(alimentoDTO.getNome());
		alimento.setTipoAlimento(alimento.getTipoAlimento());

		AlimentoDTO alimentoRetornoDTO = modelMapper.map(alimentoRepository.save(alimento), AlimentoDTO.class);

		return alimentoRetornoDTO;
	}

	@Override
	public void deletarAlimento(Long idAlimento) throws AlimentoException {
		Alimento alimento = alimentoRepository.findById(idAlimento)
				.orElseThrow(() -> new AlimentoException(MENSAGEM_ALIMENTO_INEXISTENTE + idAlimento));

		alimentoRepository.delete(alimento);

	}

}
