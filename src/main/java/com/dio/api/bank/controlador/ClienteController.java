package com.dio.api.bank.controlador;

import com.dio.api.bank.dominio.model.Cliente;
import com.dio.api.bank.servico.ClienteService;
import com.dio.api.bank.servico.impl.ClienteServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente>  findById(@PathVariable Long id){
        var cliente = clienteService.findById(id);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/")
    public List<Cliente> buscarTodos(){
        return clienteService.buscarTodos();
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente clienteToCreate){
        var created = clienteService.create(clienteToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("id")
                .buildAndExpand(clienteToCreate.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }
}
