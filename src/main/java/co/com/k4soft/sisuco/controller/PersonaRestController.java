package co.com.k4soft.sisuco.controller;

import co.com.k4soft.sisuco.model.Persona;
import co.com.k4soft.sisuco.service.persona.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("persona")
public class PersonaRestController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/personas")
    public List<Persona> findAll(){
        return personaService.findAll();
    }


}
