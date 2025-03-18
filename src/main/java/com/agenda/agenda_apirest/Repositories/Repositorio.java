package com.agenda.agenda_apirest.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.agenda.agenda_apirest.Entities.Entidades;

public interface Repositorio extends JpaRepository<Entidades, Long>{

}
