package com.example.CrudJPA;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonaRepositorio extends JpaRepository<Persona, Integer> {

    Persona findByUsuario(String usuario);
}
