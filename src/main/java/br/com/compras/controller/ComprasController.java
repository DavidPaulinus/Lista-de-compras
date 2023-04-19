package br.com.compras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compras.model.item.DTO.ListaItensDTO;
import br.com.compras.service.ComprasService;
import br.com.compras.service.ItensService;

@RestController
@RequestMapping("/compras")
public class ComprasController {
	@Autowired
	private ItensService serv;
	@Autowired
	private ComprasService servC;
	
	@GetMapping("/itens")
	public ResponseEntity<Page<ListaItensDTO>> listarItens(){
		var itens = serv.listarItens();
		
		return ResponseEntity.ok(itens.map(ListaItensDTO::new));
	}
	@GetMapping("/carrinho")
	public ResponseEntity<Page<ListaItensDTO>> listarItensCarrinho() {
		var itens = servC.listarItensCarinho(1l);
		
		return ResponseEntity.ok(itens.map(ListaItensDTO::new));
	}
	@GetMapping("/compras")
	public ResponseEntity<Page<ListaItensDTO>> listarCompras(){
		var itens = servC.listarCompras(1l);
		
		return ResponseEntity.ok(itens.map(ListaItensDTO::new));
	}
}
