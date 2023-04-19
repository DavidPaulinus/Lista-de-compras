package br.com.compras.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import br.com.compras.model.compra.Compra;
import br.com.compras.model.item.Item;
import br.com.compras.service.util.repository.ComprasRepository;

@Service
public class ComprasService {
	@Autowired
	private ComprasRepository repo;
	@Autowired
	private ItensService serv;

	public Compra crirarCompra() {
		var compra = new Compra(new ArrayList<Item>());
		repo.save(compra);

		return compra;
	}

	public Page<Item> listarItensCarinho(Long id) {
		return new PageImpl<>(detalharCarrinho(id));
	}

	public Page<Item> listarCompras(Long id) {
		return new PageImpl<>(detalharCompra(id));
	}

	public Page<Item> addCarrinho(Long id, Long idItem) {
		var itens = detalharCarrinho(id);
		itens.add(serv.detalharItem(idItem));

		return new PageImpl<>(itens);
	}

	public Page<Item> comprar(Long id) {
		var compra = detalharCompra(id);
		var carrinho = detalharCarrinho(id);

		compra.addAll(detalharCarrinho(id));
		compra.forEach(x -> x.comprado());

		carrinho.removeAll(carrinho);

		return new PageImpl<>(detalharCompra(id));
	}

	public Page<Item> removerCarrinho(Long id, Long itemId) {
		var itens = detalharCarrinho(id);
		
		for(int i = 0; i < itens.size(); i++) {
			if(itens.get(i).getId() == itemId) {
				itens.remove(i);
			}
		}
		
		return new PageImpl<>(itens);
	}

	private List<Item> detalharCarrinho(Long id) {
		return repo.getReferenceById(id).getCarrinho();
	}

	private List<Item> detalharCompra(Long id) {
		return repo.getReferenceById(id).getComprado();
	}

}
