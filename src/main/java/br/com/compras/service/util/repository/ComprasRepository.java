package br.com.compras.service.util.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.compras.model.compra.Compra;

@Repository
public interface ComprasRepository extends JpaRepository<Compra, Long> {

}
