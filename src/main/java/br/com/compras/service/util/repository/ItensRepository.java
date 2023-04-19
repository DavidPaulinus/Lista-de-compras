package br.com.compras.service.util.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.compras.model.item.Item;

@Repository
public interface ItensRepository extends JpaRepository<Item, Long>{

}
