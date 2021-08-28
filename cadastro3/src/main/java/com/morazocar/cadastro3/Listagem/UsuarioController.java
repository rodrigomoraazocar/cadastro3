package com.morazocar.cadastro3.Listagem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {this.repository = repository;}

    @GetMapping(value = "/usuario")
    public List<Usuario> getUsuario() {return repository.findAll();}


    @GetMapping(value = "/usuario/{id}")
    public Optional<Usuario> getPessoa(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping("/usuario")
    public Usuario addUsuario(@RequestBody Usuario usuario) {
        return repository.save(usuario);
    }


    @PutMapping("/usuario/{id}")
    public Usuario replaceUsuario(@RequestBody Usuario usuario, @PathVariable Long id) {
        return repository.findById(id).map(p -> {
            p.setNome(usuario.getNome());
            p.setNumero(usuario.getNumero());
            p.setEndereco(usuario.getEndereco());
            return repository.save(p);
        }).orElseGet(() -> {
            usuario.setId(id);
            return repository.save(usuario);
        });
    }


    @DeleteMapping("/usuario/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        repository.deleteById(id);
    }

}




