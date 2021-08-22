package com.jdev.crudtreinamento.domain.service;

import com.jdev.crudtreinamento.domain.exceptions.EntidadeNaoEncontradaException;
import com.jdev.crudtreinamento.domain.model.Usuario;
import com.jdev.crudtreinamento.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarOuFalhar(Long usuarioId){
        return usuarioRepository.findById(usuarioId).orElseThrow(
                ()-> new EntidadeNaoEncontradaException(String.format("Usuario nao encontrado", usuarioId)));

    }


}
