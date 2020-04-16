package com.aeg.web2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aeg.web2.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{
	
	Usuario findByNombre(String nombre);
}
