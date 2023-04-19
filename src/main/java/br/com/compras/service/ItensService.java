package br.com.compras.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import br.com.compras.model.item.Item;
import br.com.compras.service.util.repository.ItensRepository;

@Service
public class ItensService {
	@Autowired
	private ItensRepository repo;
	
	
	public Page<Item> listarItens() {
		return new PageImpl<Item>(repo.findAll());
	}

}
