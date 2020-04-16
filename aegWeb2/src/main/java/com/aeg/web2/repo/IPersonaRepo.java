package com.aeg.web2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aeg.web2.model.Persona;

public interface IPersonaRepo extends JpaRepository<Persona, Integer>{
	
}
