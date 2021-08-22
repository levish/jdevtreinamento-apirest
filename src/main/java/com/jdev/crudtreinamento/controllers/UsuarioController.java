package com.jdev.crudtreinamento.controllers;


import com.jdev.crudtreinamento.domain.exceptions.EntidadeNaoEncontradaException;
import com.jdev.crudtreinamento.domain.model.Usuario;
import com.jdev.crudtreinamento.domain.repository.UsuarioRepository;
import com.jdev.crudtreinamento.domain.service.UsuarioService;
import org.springframework.beans.BeanUtils;
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

    @PutMapping("/{userId}")
    public Usuario atualiza(@PathVariable Long userId, @RequestBody Usuario usuario){
        Usuario usuarioAtual = usuarioService.buscarOuFalhar(userId);
        BeanUtils.copyProperties(usuario, usuarioAtual, "id");
        return usuarioService.salvar(usuarioAtual);
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

//    @GetMapping("/busca")
//    public List<Usuario> buscarPorNome(@RequestParam(name = "name") String userName){
//        return usuarioRepository.buscarPorNome(userName);
//    }

    @GetMapping("/busca/{userName}")
    public List<Usuario> buscarPorNome(@PathVariable String userName){
        return usuarioRepository.buscarPorNome(userName);
    }

//    @GetMapping("/{userId}")
//    public Usuario buscaPorId(@PathVariable Long userId){
//        return usuarioService.buscarOuFalhar(userId);
//    }
}
