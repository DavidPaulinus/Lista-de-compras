package br.com.compras.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.compras.model.item.DTO.ItemDTO;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class ItemControllerTest {
	@Autowired
	private MockMvc mock;
	
	@Autowired
	private JacksonTester<ItemDTO> json;
	
	private ItemDTO dto = new ItemDTO("nome", "descrição", 2.0);
	private ItemDTO dto2 = new ItemDTO("nome2", "descrição2", 2.2);
	
	@Test
	@DisplayName("deve retornar 201 ao criar uma Tarefa")
	void shoulReurn201() throws Exception {
		var jj = json.write(dto).getJson();
		
		mock.perform(MockMvcRequestBuilders.post("/item")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jj))
				.andExpect(MockMvcResultMatchers.status().is(201));
	}
	
	@Test
	@DisplayName("deve retornar 200 ao listar todos os itens")
	void shoulReturnListAnd200() throws Exception {
		mock.perform(MockMvcRequestBuilders.get("/item")
				.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(MockMvcResultMatchers.status().is(200));
	}
	
	@Test
	@DisplayName("deve retornar 200 ao editar um item")
	void shoulReturnItemAnd200() throws Exception {
		var jj = json.write(dto2).getJson();
				
		mock.perform(MockMvcRequestBuilders.put("/item/{id}", 1)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jj))
				.andExpect(MockMvcResultMatchers.status().is(200));
	}
	@Test
	@DisplayName("deve retornar 200 ao deletar um item")
	void shoulReturnAndList200() throws Exception {
		mock.perform(MockMvcRequestBuilders.delete("/item/{id}", 5)
				.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(MockMvcResultMatchers.status().is(200));
	}
}
