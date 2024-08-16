package com.noblia.miprimeraapi.repositories;

import com.noblia.miprimeraapi.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long>{
}

