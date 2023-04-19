package br.com.compras.model.compra.DTO;

import java.util.List;

import br.com.compras.model.compra.Compra;
import br.com.compras.model.item.Item;

public record CompraDetalharDTO(Long id, List<Item> carrinho, List<Item> comprados) {
	public CompraDetalharDTO(Compra cp) {
		this(cp.getId(), cp.getCarrinho(), cp.getComprado());
	}
}
