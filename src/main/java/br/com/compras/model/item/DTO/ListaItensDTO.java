package br.com.compras.model.item.DTO;

import br.com.compras.model.item.Item;

public record ListaItensDTO(Long id, String nome, String descricao, Double valor) {
	public ListaItensDTO(Item it) {
		this(it.getId(), it.getNome(), it.getDescricao(), it.getValor());
	}
}
