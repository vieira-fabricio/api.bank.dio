package com.dio.api.bank.servico.impl;

import com.dio.api.bank.dominio.model.Cliente;
import com.dio.api.bank.dominio.repository.ClienteRepository;
import com.dio.api.bank.servico.ClienteService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ClienteServiceImpl implements ClienteService {

   private final ClienteRepository clienteRepository;

   public ClienteServiceImpl(ClienteRepository clienteRepository){
       this.clienteRepository = clienteRepository;
   }


    @Override
    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Cliente create(Cliente clienteToCreate) {
       if (clienteRepository.existsByContaNumero(clienteToCreate.getContaCorrente().getNumero())){
           throw new IllegalArgumentException("Este número de conta já existe!");
        }
        return clienteRepository.save(clienteToCreate);
    }
}
