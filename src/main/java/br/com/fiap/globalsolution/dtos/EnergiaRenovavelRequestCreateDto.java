package br.com.fiap.globalsolution.dtos;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class EnergiaRenovavelRequestCreateDto {
    private String nome;
    private String descricao;
    private int eficiencia;
    private int potenciaMaxima;
}
