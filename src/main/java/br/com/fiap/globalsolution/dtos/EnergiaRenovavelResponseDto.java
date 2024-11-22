package br.com.fiap.globalsolution.dtos;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class EnergiaRenovavelResponseDto {
    private Long id;
	private String nome;
    private String descricao;
    private int eficiencia;
    private int potenciaMaxima;
}
