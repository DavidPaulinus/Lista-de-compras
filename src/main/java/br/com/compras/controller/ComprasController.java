package br.com.compras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compras.model.compra.DTO.CompraDetalharDTO;
import br.com.compras.model.item.DTO.ListaItensDTO;
import br.com.compras.service.ComprasService;
import br.com.compras.service.ItensService;
import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;

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
	@GetMapping("/carrinho/{id}")
	public ResponseEntity<Page<ListaItensDTO>> listarItensCarrinho(@PathVariable Long id) {
		var itens = servC.listarItensCarinho(id);
		
		return ResponseEntity.ok(itens.map(ListaItensDTO::new));
	}
	@GetMapping("/compras/{id}")
	public ResponseEntity<Page<ListaItensDTO>> listarCompras(@PathVariable Long id){
		var itens = servC.listarCompras(id);
		
		return ResponseEntity.ok(itens.map(ListaItensDTO::new));
	}
	@GetMapping
	public ResponseEntity<CompraDetalharDTO> criarCompra() {
		return ResponseEntity.ok(new CompraDetalharDTO(servC.crirarCompra()));
	}
	
	@PostMapping("/add/{id}")
	@Transactional
	public ResponseEntity<Page<ListaItensDTO>> adicionarAoCarrinho(@PathVariable Long id, @PathParam("idItem") Long idItem){
		 var itens = servC.addCarrinho(id, idItem);
		 
		 return ResponseEntity.ok(itens.map(ListaItensDTO::new));
	}
	@PostMapping("/comprar/{id}")
	@Transactional
	public ResponseEntity<Page<ListaItensDTO>> comprar(@PathVariable Long id){
		 var itens = servC.comprar(id);
		 
		 return ResponseEntity.ok(itens.map(ListaItensDTO::new));
	}
	
}
