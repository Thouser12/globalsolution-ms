package br.com.fiap.globalsolution.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.globalsolution.model.EnergiaRenovavelModel;

public interface EnergiaRenovavelRepository extends JpaRepository<EnergiaRenovavelModel, Long>  {

    <T> List<T> findByNome(String nome);
    <T> List<T> findAllByNomeContains(String nome);
    
} 
