package com.morazocar.cadastro3.Listagem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {


}
