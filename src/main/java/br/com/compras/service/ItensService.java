package br.com.compras.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import br.com.compras.model.item.Item;
import br.com.compras.model.item.DTO.ItemDTO;
import br.com.compras.service.util.repository.ItensRepository;

@Service
public class ItensService {
	@Autowired
	private ItensRepository repo;
	
	
	public Page<Item> listarItens() {
		return new PageImpl<Item>(repo.findAll());
	}
	
	public Item detalharItem(Long id) {
		return repo.getReferenceById(id);
	}
	
	public Item cadatrar(ItemDTO dto) {
		var item = new Item(dto);
		repo.save(item);
		
		return item;
	}

	public Item editar(ItemDTO dto, Long id) {
		var item = repo.findById(id).orElseThrow(() -> new RuntimeException("Não foi possível achar um item com esse ID"));
		item.atualizar(dto);
		
		return item;
	}

	public Page<Item> apagar(Long id) {
		repo.deleteById(id);
		return new PageImpl<>(repo.findAll());
	}

}
