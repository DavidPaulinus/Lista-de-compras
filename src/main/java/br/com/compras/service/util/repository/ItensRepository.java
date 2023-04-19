package br.com.compras.service.util.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compras.model.item.Item;

public interface ItensRepository extends JpaRepository<Item, Long>{

}
