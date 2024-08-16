package com.noblia.miprimeraapi.services;


import com.noblia.miprimeraapi.entities.Persona;
import com.noblia.miprimeraapi.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository PersonaRepository;

    public List<Persona> getPersonas() {
        return PersonaRepository.findAll();
    }

    public Persona getPersonaPorId(Long id) {
        return PersonaRepository.findById(id).orElse(null);
    }

    public Persona crearPersona(Persona Persona) {
        return PersonaRepository.save(Persona);
    }

    public Persona actualizarPersona(Long id, Persona Persona) {
        if (PersonaRepository.existsById(id)) {
            Persona.setId(id);
            return PersonaRepository.save(Persona);
        } else {
            return null;
        }
    }

    public void eliminarPersona(Long id) {
        PersonaRepository.deleteById(id);
    }
}