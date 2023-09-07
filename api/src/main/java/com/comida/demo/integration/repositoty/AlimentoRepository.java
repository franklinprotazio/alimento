package com.comida.demo.integration.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comida.demo.core.entity.Alimento;

public interface AlimentoRepository extends JpaRepository<Alimento, Long>{

}
