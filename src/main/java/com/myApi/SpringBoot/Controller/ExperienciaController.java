/*Perrotta Vicente Grupo 141 */
package com.myApi.SpringBoot.Controller;


import com.myApi.SpringBoot.Model.Experiencia;
import com.myApi.SpringBoot.Service.ExperienciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class ExperienciaController {
    
   @Autowired
    ExperienciaService experienciaService;

    /*Método GET*/
   @PreAuthorize("permitAll")
    @GetMapping("/experiencia/todas")
    public ResponseEntity<List<Experiencia>> getAllEstudios() {
        List<Experiencia> experiencia = experienciaService.listarExperiencias();
        return new ResponseEntity<>(experiencia, HttpStatus.OK);
    }
    /*otra forma de obtener listado */
    @PreAuthorize("permitAll")
    @GetMapping("/experiencia2/all")
    @ResponseBody
    public List<Experiencia> buscarTodas() {
        return experienciaService.listarExperiencias();
    }
    
     @PreAuthorize("permitAll")   
    @GetMapping ("/experiencia/obtener/{id}")
    @ResponseBody
    public Experiencia obtenerExperiencia(@PathVariable Long id) {
        return experienciaService.obtenerExperiencia(id);
    }
    
    @PreAuthorize("permitAll")
     @GetMapping("/experiencia/{id}")
    public ResponseEntity<Experiencia> findExperiencia(@PathVariable("id") Long id) {
        Experiencia experienciaLaboral = experienciaService.obtenerExperiencia(id);
        return new ResponseEntity<>(experienciaLaboral, HttpStatus.OK);
    }

    
    /*Método PUT I use "preautorize" to request a role to execute the method */
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/modifica/experiencia")
    public ResponseEntity<Experiencia> modificarExperiencia(@RequestBody Experiencia experiencia) {
        experienciaService.modificarExperiencia(experiencia);
        return new ResponseEntity<>(HttpStatus.OK);
    }
  

    /*Método POST I use "preautorize" to request a role to execute the method */
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/experiencia")
    public void crearExperiencia(@RequestBody Experiencia experiencia) {
        experienciaService.crearExperiencia(experiencia);
    }

      
    /*Método DELETE I use "preautorize" to request a role to execute the method */
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/experiencia/{id}")
    public void borrarExperiencia(@PathVariable Long id) {
        experienciaService.borrarExperiencia(id);
    } 
    
    
}
