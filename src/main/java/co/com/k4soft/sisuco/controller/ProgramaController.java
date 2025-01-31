package co.com.k4soft.sisuco.controller;

import co.com.k4soft.sisuco.model.Programa;
import co.com.k4soft.sisuco.service.programa.ProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/programa")
public class ProgramaController {
    @Autowired
    private ProgramaService programaService;

    @GetMapping("/programas")
    public List<Programa> findAll(){
        return programaService.findAll();
    }
}
