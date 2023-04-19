package br.com.compras.service;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ActiveProfiles;

import br.com.compras.model.item.Item;
import br.com.compras.model.item.DTO.ItemDTO;
import br.com.compras.service.util.repository.ItensRepository;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ItensServiceTest {
	@MockBean
	private ItensRepository repo;
	@Autowired
	private ItensService serv;
	
	private ItemDTO dto = new ItemDTO("N","D",2.2);
	
	@Test
	@DisplayName("deve retornar Page com itens")
	void shouldReturnAPageWithItems() {
		var itens = serv.listarItens();
		
		assertInstanceOf(Page.class, itens);
	}
	
	@Test
	@DisplayName("não deve retornar um item")
	void shouldNotReturnASingleItemById() {
		var itens = serv.detalharItem(1l);
		
		assertNull(itens);
	}
	
	@Test
	@DisplayName("deve retornar um item depois de cadastrar")
	void shouldReturnASingleItemCreated() {
		var itens = serv.cadatrar(dto);
		
		assertInstanceOf(Item.class, itens);
	}
	
	@Test
	@DisplayName("não deve retornar um item depois de editar ele")
	void shouldNotReturnASingleItemEdited() {
		var itens = serv.editar(dto, 1l);
		
		assertNull(itens);
	}
	
	@Test
	@DisplayName("deve retornar Page com itens")
	void shouldNotReturnAPageWithItemsAfterRemove() {
		var itens = serv.apagar(1l);
		
		assertNull(itens);
	}
}
