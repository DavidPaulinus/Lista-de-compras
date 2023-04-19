package br.com.compras.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class ComprasControllerTest {
	@Autowired
	private MockMvc mock;
	
	@Test
	@DisplayName("deve retornar 200 ao listar todos os itens no carrinho")
	void shouldReturnTheListOfItemsInTheCart() throws Exception {
		mock.perform(MockMvcRequestBuilders.get("/compras/carrinho/{id}", 1)
				.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(MockMvcResultMatchers.status().is(200));
	}
	@Test
	@DisplayName("deve retornar 200 ao listar todos os itens")
	void shouldReturnTheItemsList() throws Exception {
		mock.perform(MockMvcRequestBuilders.get("/compras/itens")
				.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(MockMvcResultMatchers.status().is(200));
	}
	@Test
	@DisplayName("deve retornar 200 ao listar todos os itens comprados")
	void shouldReturnTheShoppingList() throws Exception {
		mock.perform(MockMvcRequestBuilders.get("/compras/compras/{id}", 1)
				.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(MockMvcResultMatchers.status().is(200));
	}
	@Test
	@DisplayName("deve retornar 200 ao criar um tipo Compra")
	void shouldReturnACompraInstance() throws Exception {
		mock.perform(MockMvcRequestBuilders.get("/compras")
				.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(MockMvcResultMatchers.status().is(200));
	}
	
	@Test
	@DisplayName("deve retornar 200 ao adicionar um Item no carrinho")
	void shouldAddAnItemToTheCart() throws Exception {
		mock.perform(MockMvcRequestBuilders.post("/compras/add/{id}", 1)
				.param("idItem", "1")
				.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(MockMvcResultMatchers.status().is(200));
	}
	@Test
	@DisplayName("deve retornar 200 ao comprar os itens")
	void shouldBuyTheItems() throws Exception {
		mock.perform(MockMvcRequestBuilders.post("/compras/comprar/{id}", 2)
				.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(MockMvcResultMatchers.status().is(200));
	}
	
	@Test
	@DisplayName("deve retornar 200 ao remover um Item no carrinho")
	void shouldRemoveAnItemFromCart() throws Exception {
		mock.perform(MockMvcRequestBuilders.delete("/compras/carrinho/remove/{id}", 1)
				.param("item", "1")
				.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(MockMvcResultMatchers.status().is(200));
	}
}
