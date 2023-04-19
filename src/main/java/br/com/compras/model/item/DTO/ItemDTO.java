package br.com.compras.model.item.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ItemDTO(
		@NotBlank
		String nome,
		
		@NotBlank
		String descricao,
		
		@NotNull
		Double valor
		) {

}
