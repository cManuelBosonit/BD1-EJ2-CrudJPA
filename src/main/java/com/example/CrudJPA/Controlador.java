package com.example.CrudJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controlador {
    @Autowired
    PersonaRepositorio personaRepositorio;

    @GetMapping("/persona")
    public List<Persona> getAll(){
        return personaRepositorio.findAll();
    }

    //POST
    //Añade personas a la BBDD
    /*localhost:8080/persona
    {
        "usuario": "Usuario1",
        "password": "seguro",
        "name": "Manuel",
        "surname": "Hernández",
        "company_email": "MH@email.com",
        "personal_email": "MHpersonal@email.com",
        "city": "Madrid",
        "active": true,
        "created_date": "2022-02-07",
        "imagen_url": "url",
        "termination_date": "2022-02-07"
    }
     */
    @PostMapping("/persona")
    public Persona addPersona(@RequestBody Persona persona) throws Exception {
        personaRepositorio.saveAndFlush(persona);

        String message;

//        if(persona.usuario == null){
//            throw new Exception("Usuario no puede ser null") ;
//        }else if(persona.usuario.length() < 10){
//            throw new Exception("Longitud de usuario no puede ser superior a 10 caracteres");  ;
//            {
//            personaRepositorio.saveAndFlush(persona);
//            message = "Añadido " + persona;
//        }
        return persona;
    }

    //GET
    //Busca personas por ID
    //localhost:8080/persona/id/1
    @GetMapping("/persona/id/{id_persona}")
    public Persona getByID(@PathVariable Integer id_persona) throws Exception{
        return personaRepositorio.findById(id_persona).orElseThrow(() -> new Exception("Id no encontrado"));
    }

    //GET
    //Busca personas por Usuario
    //localhost:8080/persona/usuario/Usuario1
    @GetMapping("/persona/usuario/{usuario}")
    public Persona getByUser(@PathVariable String usuario) {
        return personaRepositorio.findByUsuario(usuario);
    }


}
