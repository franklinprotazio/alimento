package com.comida.demo.config;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.comida.demo.core.entity.Alimento;
import com.comida.demo.v1.dto.AlimentoDTO;

@Configuration
public class ModelMapperConfiguration {

	@Bean
	public static ModelMapper getModelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		modelMapper.addConverter(converterStringToString());
		modelMapper.typeMap(Alimento.class, AlimentoDTO.class);

		return modelMapper;
	}

	private static Converter<String, String> converterStringToString() {
		return new AbstractConverter<String, String>() {
			protected String convert(String source) {
				return source == null ? null : source.trim();
			}
		};
	}
	
}
