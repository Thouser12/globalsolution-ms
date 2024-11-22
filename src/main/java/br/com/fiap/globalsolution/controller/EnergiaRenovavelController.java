package br.com.fiap.globalsolution.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.globalsolution.dtos.EnergiaRenovavelRequestCreateDto;
import br.com.fiap.globalsolution.dtos.EnergiaRenovavelRequestUpdateDto;
import br.com.fiap.globalsolution.dtos.EnergiaRenovavelResponseDto;
import br.com.fiap.globalsolution.mapper.EnergiaRenovavelMapper;
import br.com.fiap.globalsolution.repository.EnergiaRenovavelRepository;
import br.com.fiap.globalsolution.service.EnergiaRenovavelService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/energias-renovaveis")
@RequiredArgsConstructor
public class EnergiaRenovavelController {
    private final EnergiaRenovavelService energiaRenovavelService;
	private final EnergiaRenovavelMapper energiaRenovavelMapper;
    private final EnergiaRenovavelRepository energiaRenovavelRepository;

    @GetMapping
    public ResponseEntity<List<EnergiaRenovavelResponseDto>> list() {
        List<EnergiaRenovavelResponseDto> dtos = energiaRenovavelService.list()
            .stream()
            .map(e -> energiaRenovavelMapper.toDto(e))
            .toList();
        
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<EnergiaRenovavelResponseDto> create(@RequestBody EnergiaRenovavelRequestCreateDto dto) {        
        return ResponseEntity
        		.status(HttpStatus.CREATED)
        		.body(
        			energiaRenovavelMapper.toDto(
        					energiaRenovavelService.save(energiaRenovavelMapper.toModel(dto)))
        			);
    }

    @PutMapping("{id}")
    public ResponseEntity<EnergiaRenovavelResponseDto> update(
                        @PathVariable Long id, 
                        @RequestBody EnergiaRenovavelRequestUpdateDto dto) {
        if (! energiaRenovavelService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }                
        return ResponseEntity.ok()
        		.body(
        			energiaRenovavelMapper.toDto(
        				energiaRenovavelService.save(energiaRenovavelMapper.toModel(id, dto)))
        		);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if (! energiaRenovavelService.existsById(id)){
        	throw new RuntimeException("Id inexistente");
        }

        energiaRenovavelService.delete(id);
    }

    @GetMapping("{id}")
    public ResponseEntity<EnergiaRenovavelResponseDto> findById(@PathVariable Long id) {    	
    	return ResponseEntity.ok()
    			.body(
    				energiaRenovavelService
    					.findById(id)
    					.map(e -> energiaRenovavelMapper.toDto(e))
    					.orElseThrow(() -> new RuntimeException("Id inexistente"))
    			);
    	  		     
    }

    @GetMapping("/")
    public  ResponseEntity<?> findByNome(
                @RequestParam String nome) { 

        return ResponseEntity.ok().body(energiaRenovavelRepository.findAllByNomeContains(nome));  
    }

}
