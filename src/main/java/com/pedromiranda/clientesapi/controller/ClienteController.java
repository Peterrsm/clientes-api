package com.pedromiranda.clientesapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pedromiranda.clientesapi.entity.Cliente;
import com.pedromiranda.clientesapi.request.ClienteRequest;
import com.pedromiranda.clientesapi.service.ClienteService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService service;

    @ApiOperation("Retorna a lista de todos os clientes já presentes no banc de dados")
    @GetMapping("/")
    public List<Cliente> getAllClientes() {
        return service.getAllClientes();
    }

    @ApiOperation("Retorna um cliente, buscando pelo id do banco de dados")
    @GetMapping("/id/{id}")
    public Optional<Cliente> getCliente(@PathVariable ("id") Long id) {
        return service.getClienteById(id);
    }

    @GetMapping("/ddd/{ddd}")
    public List<Cliente> getClienteByDdd(@PathVariable ("ddd") String ddd) {
        return service.getClientesByDdd(ddd);
    }

    @GetMapping("/nome/{nome}")
    public List<Cliente> getClienteByNome(@PathVariable ("nome") String nome) {
        return service.getClientesByNome(nome);
    }

    @PostMapping("/")
    public Cliente addCliente(@RequestBody ClienteRequest cliente) throws JsonProcessingException {
        Cliente cli = new Cliente();
        cli.setNome(cliente.getNome());
        cli.setCpf(cliente.getCpf());
        for(String item : cliente.getEmails()){
            cli.addEmail(item);
        }
        for(String item : cliente.getCelulares()){
            cli.addCelular(item);
        }

        return service.addCliente(cli);
    }

    @PutMapping("/id/{id}")
    public void editaCliente(@PathVariable ("id") Long id, @RequestBody ClienteRequest cli) {
        Cliente cliente = service.getClienteById(id).orElseThrow();

        cliente.setNome(cli.getNome());
        cliente.setCpf(cli.getCpf());

        for(String item : cli.getEmails()){
            cliente.addEmail(item);
        }
        for(String item : cli.getCelulares()){
            cliente.addCelular(item);
        }

        service.updateCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable ("id") Long id) {
        service.removeCliente(id);
    }
}
