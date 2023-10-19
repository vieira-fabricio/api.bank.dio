package com.dio.api.bank.servico;

import com.dio.api.bank.dominio.model.Cliente;

public interface ClienteService {

    Cliente findById(Long id);

    Cliente create(Cliente clienteToCreate);
}
