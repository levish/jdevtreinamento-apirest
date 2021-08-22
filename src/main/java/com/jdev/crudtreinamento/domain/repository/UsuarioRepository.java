package com.jdev.crudtreinamento.domain.repository;

import com.jdev.crudtreinamento.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    @Query(value = "select u from Usuario u where trim(u.nome) like %?1%")
    List<Usuario> buscarPorNome(String name);
}
