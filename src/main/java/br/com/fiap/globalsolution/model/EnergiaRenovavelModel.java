package br.com.fiap.globalsolution.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class EnergiaRenovavelModel {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(nullable = false, length = 60)
	private String nome;

    @Column(length = 100)
    private String descricao;

    @Column(nullable = false)
    private int eficiencia;

    @Column(nullable = false)
    private int potenciaMaxima;
}
