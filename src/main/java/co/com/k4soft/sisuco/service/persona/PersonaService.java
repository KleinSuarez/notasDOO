package co.com.k4soft.sisuco.service.persona;

import co.com.k4soft.sisuco.model.Persona;

import java.util.List;

public interface PersonaService {


    List<Persona> findAll();


    void insert(Persona persona);
}
