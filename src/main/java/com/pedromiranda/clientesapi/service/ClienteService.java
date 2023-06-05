package com.pedromiranda.clientesapi.service;

import com.pedromiranda.clientesapi.entity.Cliente;
import com.pedromiranda.clientesapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> getAllClientes() {
        return (List<Cliente>) repository.findAll();
    }

    public List<Cliente> getClientesByDdd(String ddd) {
        return repository.buscarPorDdd(ddd);
    }

    public List<Cliente> getClientesByNome(String nome) {
        return repository.buscarPorNome(nome);
    }

    public Cliente addCliente(Cliente cliente) {
        return repository.save(cliente);
    }

    public Optional<Cliente> getClienteById(Long id) {
        return repository.findById(Math.toIntExact(id));
    }

    public void updateCliente(Cliente cliente) {
        repository.save(cliente);
    }

    public void removeCliente(Long id) {
        repository.deleteById(Math.toIntExact(id));
    }
}
