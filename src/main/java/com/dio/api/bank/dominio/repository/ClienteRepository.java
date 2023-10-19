package com.dio.api.bank.dominio.repository;

import com.dio.api.bank.dominio.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    boolean existsByContaNumero(String contaNumero);
}
