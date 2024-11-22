package br.com.fiap.globalsolution.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.globalsolution.dtos.EnergiaRenovavelRequestCreateDto;
import br.com.fiap.globalsolution.dtos.EnergiaRenovavelRequestUpdateDto;
import br.com.fiap.globalsolution.dtos.EnergiaRenovavelResponseDto;
import br.com.fiap.globalsolution.model.EnergiaRenovavelModel;

@Component
public class EnergiaRenovavelMapper {
    @Autowired
    private  ModelMapper modelMapper;

    public EnergiaRenovavelResponseDto toDto(EnergiaRenovavelModel energiaRenovavel) {
        return modelMapper.map(energiaRenovavel, EnergiaRenovavelResponseDto.class);
    }

    public EnergiaRenovavelModel toModel(EnergiaRenovavelRequestCreateDto dto) {
        return modelMapper.map(dto, EnergiaRenovavelModel.class);
    }

    public EnergiaRenovavelModel toModel(Long id,EnergiaRenovavelRequestUpdateDto dto) {
        EnergiaRenovavelModel result = modelMapper.map(dto, EnergiaRenovavelModel.class);
        result.setId(id);
        return result;
    }
}
