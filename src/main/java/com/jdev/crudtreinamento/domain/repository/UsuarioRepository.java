package com.jdev.crudtreinamento.domain.repository;

import com.jdev.crudtreinamento.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
