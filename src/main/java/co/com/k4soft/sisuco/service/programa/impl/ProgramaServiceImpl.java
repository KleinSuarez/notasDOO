package co.com.k4soft.sisuco.service.programa.impl;

import co.com.k4soft.sisuco.model.Programa;

import co.com.k4soft.sisuco.repository.ProgramaRepository;
import co.com.k4soft.sisuco.service.programa.ProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramaServiceImpl implements ProgramaService {

    @Autowired
    private ProgramaRepository programaRepository;


    @Override
    public List<Programa> findAll() {
        return programaRepository.findAll();
    }
}
