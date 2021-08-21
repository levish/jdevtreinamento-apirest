package com.jdev.crudtreinamento.controllers;


import com.jdev.crudtreinamento.domain.model.Usuario;
import com.jdev.crudtreinamento.domain.repository.UsuarioRepository;
import com.jdev.crudtreinamento.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Usuario>> listarUsuario(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public Usuario buscaPorId(@PathVariable Long userId){
        return usuarioService.buscarOuFalhar(userId);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Usuario> salvar(@RequestBody  Usuario usuario){
        Usuario usuario1 = usuarioRepository.save(usuario);
        return new ResponseEntity<Usuario>(usuario1, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam Long iduser){
        usuarioRepository.deleteById(iduser);
        return new ResponseEntity<String>("User deletado com sucesso", HttpStatus.OK);
    }
}
