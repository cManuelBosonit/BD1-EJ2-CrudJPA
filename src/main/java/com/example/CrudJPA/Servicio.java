package com.example.CrudJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Servicio {

    @Autowired
    PersonaRepositorio personaRepositorio;
}
