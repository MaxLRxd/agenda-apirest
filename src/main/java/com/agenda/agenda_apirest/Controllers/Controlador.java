package com.agenda.agenda_apirest.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.agenda.agenda_apirest.Repositories.Repositorio;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import com.agenda.agenda_apirest.Entities.Entidades;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/agendas")
public class Controlador {
    @Autowired
    private Repositorio repositorios;

    @GetMapping
    public List<Entidades>getAllEntidades(){
        return repositorios.findAll();
    }

    @PostMapping
    public Entidades crearEntidad(@RequestBody Entidades entidad){
        return repositorios.save(entidad);
    }

    @PostMapping
    public Entidades updateEntidad(@PathVariable Long id, @RequestBody Entidades entidad) {
        Entidades entidad1 = repositorios.findById(id).orElseThrow(()-> new RuntimeException("el id " + id + "no fué encontrado"));
        entidad1.setNombre(entidad.getNombre());
        entidad1.setNota(entidad.getNota());
        return entidad;
    }

    @DeleteMapping("/{id}")
    public String borrarEntidad(@PathVariable Long id){
        Entidades entidad2 = repositorios.findById(id).orElseThrow(()-> new RuntimeException());
        repositorios.delete(entidad2);
        return "Borrado exitosamente";
    }
}
