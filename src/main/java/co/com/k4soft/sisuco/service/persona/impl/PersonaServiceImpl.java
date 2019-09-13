package co.com.k4soft.sisuco.service.persona.impl;

import co.com.k4soft.sisuco.model.Persona;
import co.com.k4soft.sisuco.repository.PersonaRepository;
import co.com.k4soft.sisuco.service.persona.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;


    @Override
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    @Override
    public void insert(Persona persona) {
        personaRepository.save(persona);
    }
}
