/*Perrotta Vicente grupo 141*/
package com.myApi.SpringBoot.Service;

import com.myApi.SpringBoot.Model.Experiencia;
import com.myApi.SpringBoot.Repository.ExperienciaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService {

    @Autowired
    ExperienciaRepository repositorioExperiencia;

    public ExperienciaService(ExperienciaRepository repositorioExperiencia) {
        this.repositorioExperiencia = repositorioExperiencia;
    }

    @Override
    public void crearExperiencia(Experiencia experiencia) {
        repositorioExperiencia.save(experiencia);
    }

    @Override
    public void borrarExperiencia(Long id) {
        repositorioExperiencia.deleteById(id);
    }

    @Override
    public List<Experiencia> listarExperiencias() {
        return repositorioExperiencia.findAll();
    }

    public Experiencia obtenerExperiencia(Long id) {
        return repositorioExperiencia.findById(id).orElse(null);
    }

    public void modificarExperiencia(Experiencia experiencia) {
        repositorioExperiencia.save(experiencia);
    }
    
    
}
