package br.com.fiap.globalsolution.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.globalsolution.model.EnergiaRenovavelModel;
import br.com.fiap.globalsolution.repository.EnergiaRenovavelRepository;

@Service
public class EnergiaRenovavelService {
    
    @Autowired
    private EnergiaRenovavelRepository energiaRenovavelRepository;

    public List<EnergiaRenovavelModel> list() {
        return energiaRenovavelRepository.findAll();
    }

    public EnergiaRenovavelModel save(EnergiaRenovavelModel energiaRenovavelModel) {
        return energiaRenovavelRepository.save(energiaRenovavelModel);
    }

    public boolean existsById(Long id) {
        return energiaRenovavelRepository.existsById(id);
    }

    public void delete(Long id) {
        energiaRenovavelRepository.deleteById(id);
    }

    public Optional<EnergiaRenovavelModel> findById(Long id) {
        return energiaRenovavelRepository.findById(id);
    }
}
