package br.com.compras.model.item;

import br.com.compras.model.item.DTO.ItemDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_itens")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private Double valor;
	private Boolean comprado;

	public Item(ItemDTO dto) {
		this.nome = dto.nome();
		this.descricao = dto.descricao();
		this.valor = dto.valor();
		this.comprado = false;
	}

	public void atualizar(ItemDTO dto) {
		this.nome = dto.nome();
		this.descricao = dto.descricao();
		this.valor = dto.valor();
	}

	public void comprado() {
		this.comprado = true;
	}
}
