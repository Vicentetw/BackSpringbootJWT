/*Perrotta Vicente grupo 141*/

package com.myApi.SpringBoot.Service;

import com.myApi.SpringBoot.Model.Persona;
import com.myApi.SpringBoot.Repository.PersonaRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonaService implements IPersonaService {
@Autowired
PersonaRepository repositorioPersona;

    @Override
    public void crearPersona(Persona persona) {
       repositorioPersona.save(persona);
    }
    
    public Persona obtenerPersona(Long id)
    {
        return repositorioPersona.findById(id).orElse(null);
    }
    
     public void modificarPersona(Persona persona)
    {
    repositorioPersona.save(persona);
    }
     
    @Override
    public void borrarPersona(Long id) {
       repositorioPersona.deleteById(id);
    }

    @Override
    public List<Persona> listarPersonas() {

        return repositorioPersona.findAll();
    }

    
    public List<Persona> buscarPersonaPorNombre(String apellido)
    {
    return repositorioPersona.findByApellidoLike(apellido);
    }
}
