/*Perrotta Vicente grupo 141*/
package com.myApi.SpringBoot.Service;

import com.myApi.SpringBoot.Model.Experiencia;
import com.myApi.SpringBoot.Repository.ExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
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
    public List<Experiencia> listarExperiencias() {
        return repositorioExperiencia.findAll();
    }

    public Experiencia obtenerExperiencia(Long id) {
        return repositorioExperiencia.findById(id).orElse(null);
    }
    /*otra forma de obtener por id*/
    public Optional<Experiencia>getOne(Long id){
    return repositorioExperiencia.findById(id);
            }
    
    public void modificarExperiencia(Experiencia experiencia) {
        repositorioExperiencia.save(experiencia);
    }
    @Override
    public void borrarExperiencia(Long id) {
        repositorioExperiencia.deleteById(id);
    }
     
    public boolean existsById(Long id){
    return repositorioExperiencia.existsById(id);
    }
    
    
    
}
