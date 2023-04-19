package br.com.compras.service;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ActiveProfiles;

import br.com.compras.model.compra.Compra;
import br.com.compras.service.util.repository.ComprasRepository;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ComprasServiceTest {
	@MockBean
	private ComprasRepository repo;
	@Autowired
	private ComprasService serv;
	
	@Test
	@DisplayName("deve retornar Page com itens no carrinho")
	void shouldReturnAPageWithItemsInTheCart() {
		var itens = serv.listarItensCarinho(1l);
		
		assertInstanceOf(Page.class, itens);
	}
	
	@Test
	@DisplayName("deve retornar uma Compra depois de cadastrar")
	void shouldReturnASingleCompraCreated() {
		var itens = serv.crirarCompra();
		
		assertInstanceOf(Compra.class, itens);
	}
	
	@Test
	@DisplayName("deve retornar Page com itens comprados")
	void shouldReturnAPageWithItemsBought() {
		var itens = serv.listarCompras(1l);
		
		assertInstanceOf(Page.class, itens);
	}
	
	@Test
	@DisplayName("deve adicionar um item ao carrinho")
	void shouldAddItemToTheCart() {
		var itens = serv.addCarrinho(1l, 1l);
		
		assertInstanceOf(Page.class, itens);
	}
	
	@Test
	@DisplayName("deve comprar os itens no carrinho")
	void shouldBuyTheItems() {
		var itens = serv.comprar(1l);
		
		assertInstanceOf(Page.class, itens);
	}
	
	@Test
	@DisplayName("deve remover um item do carrinho")
	void shouldRemoveAnItemFromTheCart() {
		var itens = serv.removerCarrinho(1l,1l);
		
		assertInstanceOf(Page.class, itens);
	}
}
