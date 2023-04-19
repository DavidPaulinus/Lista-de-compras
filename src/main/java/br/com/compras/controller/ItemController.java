package br.com.compras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.compras.model.item.DTO.ItemDTO;
import br.com.compras.model.item.DTO.ListaItensDTO;
import br.com.compras.service.ItensService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItensService serv;

	@GetMapping
	public ResponseEntity<Page<ListaItensDTO>> listarItens() {
		var itens = serv.listarItens();

		return ResponseEntity.ok(itens.map(ListaItensDTO::new));
	}

	@PostMapping
	@Transactional
	public ResponseEntity<ListaItensDTO> cadastrarItem(@RequestBody ItemDTO dto, UriComponentsBuilder uri) {
		var item = serv.cadatrar(dto);

		return ResponseEntity.created(uri.path("/itens")
										.buildAndExpand(item.getId())
										.toUri()
										)
										.body(new ListaItensDTO(item));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ListaItensDTO> editarItem(@RequestBody ItemDTO dto, @PathVariable Long id){
		var item = serv.editar(dto, id);
		
		return ResponseEntity.ok(new ListaItensDTO(item));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Page<ListaItensDTO>> apagarItem(@PathVariable Long id){
		var item = serv.apagar(id) ;
		
		return ResponseEntity.ok(item.map(ListaItensDTO::new));
	}
}
