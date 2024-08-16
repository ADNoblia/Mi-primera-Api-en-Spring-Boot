package com.noblia.miprimeraapi.controllers;

import com.noblia.miprimeraapi.entities.Persona;
import com.noblia.miprimeraapi.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Ps")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<Persona> getPs() {
        return personaService.getPersonas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersonaPorId(@PathVariable Long id) {
        Persona P = personaService.getPersonaPorId(id);
        if (P != null) {
            return ResponseEntity.ok(P);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Persona crearP(@RequestBody Persona P) {
        return personaService.crearPersona(P);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> actualizarP(@PathVariable Long id, @RequestBody Persona P) {
        Persona actualizarPersona = personaService.actualizarPersona(id, P);
        if (actualizarPersona != null) {
            return ResponseEntity.ok(actualizarPersona);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Persona> patchP(@PathVariable Long id, @RequestBody Persona P) {
        Persona existingPersona = personaService.getPersonaPorId(id);
        if (existingPersona != null) {
            if (P.getNombre() != null) {
                existingPersona.setNombre(P.getNombre());
            }
            if (P.getEmail() != null) {
                existingPersona.setEmail(P.getEmail());
            }
            personaService.actualizarPersona(id, P);
            return ResponseEntity.ok(existingPersona);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteP(@PathVariable Long id) {
        personaService.eliminarPersona(id);
        return ResponseEntity.noContent().build();
    }
}