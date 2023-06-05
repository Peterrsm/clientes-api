package com.pedromiranda.clientesapi.repository;

import com.pedromiranda.clientesapi.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query(value = "SELECT * " +
            "FROM clientes a " +
            "INNER JOIN cliente_celulares b on a.id = b.cliente_id \n" +
            "WHERE b.celulares LIKE :ddd%", nativeQuery = true)
    List<Cliente> buscarPorDdd(@Param("ddd") String ddd);

    @Query(value = "SELECT * " +
            "FROM clientes a " +
            "WHERE a.nome LIKE %:nome%", nativeQuery = true)
    List<Cliente> buscarPorNome(@Param("nome") String nome);
}
