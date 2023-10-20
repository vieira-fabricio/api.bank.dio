package com.dio.api.bank.servico;

import com.dio.api.bank.dominio.model.Cliente;

import java.util.List;

public interface ClienteService {

    Cliente findById(Long id);

    Cliente create(Cliente clienteToCreate);

    List<Cliente> buscarTodos();
}
