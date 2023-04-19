package br.com.compras.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import br.com.compras.model.item.Item;
import br.com.compras.service.util.repository.ComprasRepository;

@Service
public class ComprasService {
	@Autowired
	private ComprasRepository repo;
	
	public Page<Item> listarItensCarinho(Long id) {
		return new PageImpl<>(repo.getReferenceById(id).getCarrinho());
	}

	public Page<Item> listarCompras(Long id) {
		return new PageImpl<>(repo.getReferenceById(id).getComprado());
	}
	
}
