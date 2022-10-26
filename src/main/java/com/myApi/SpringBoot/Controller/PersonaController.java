package com.myApi.SpringBoot.Controller;

import com.myApi.SpringBoot.Model.Persona;
import com.myApi.SpringBoot.Service.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*@CrossOrigin(origins = {"https://portfolio-angular-81057.web.app/"})*/
@CrossOrigin(origins = "*")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    /*
    @GetMapping("/persona")
    public String saludar(@RequestParam String nombre) {
        return "Bienvenidos a Arg. Programa. Soy " + nombre;
    }
    */
    /*PreAuthorize I use "preautorize" to request a role to execute the method */
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/persona")
    public void crearPersona(@RequestBody Persona persona) {
        personaService.crearPersona(persona);
    }
    
    @GetMapping("/persona/{id}")
    @ResponseBody
    public Persona obtenerPersona(@PathVariable Long id) {
        return personaService.obtenerPersona(id);
    }
    
    @GetMapping("/persona/nombre/{nombre}")
    @ResponseBody
    public List<Persona> buscarPorUbicacion(@PathVariable String nombre)
    {
    return personaService.buscarPersonaPorNombre(nombre);
    }
    
    @GetMapping("/persona/todas")
    @ResponseBody
    public List<Persona> buscarTodas()
    {
    return personaService.listarPersonas();
    }
    @PreAuthorize("hasRole('ADMIN')")    
    @PutMapping("/modifica/persona")
    public void modificarPersona(@RequestBody Persona persona) {
        personaService.modificarPersona(persona);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/persona/{id}")
    public void borrarPersona(@PathVariable Long id) {
        personaService.borrarPersona(id);
    }

   
    
    
    
}
