/*Perrotta Vicente Grupo 141 */
package com.myApi.SpringBoot.Controller;

import com.myApi.SpringBoot.Model.Educacion;
import com.myApi.SpringBoot.Service.EducacionService;
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
@CrossOrigin(origins = {"https://perrotta-vicente.web.app"})
//@CrossOrigin(origins = "*")

public class EducacionController {

    @Autowired
    EducacionService educacionService;

    @PostMapping("/educacion")
@PreAuthorize("hasRole('ADMIN')")
    public void crearEducacion(@RequestBody Educacion educacion) {
        educacionService.crearEducacion(educacion);
    }

    /*Método GET*/
    @PreAuthorize("permitAll")
    @GetMapping("/educacion/all")
    public ResponseEntity<List<Educacion>> getAllEstudios() {
        List<Educacion> educacion = educacionService.listarEducacion();
        return new ResponseEntity<>(educacion, HttpStatus.OK);
    }

    @PreAuthorize("permitAll")
    @GetMapping("/educacion2/all")
    @ResponseBody
    public List<Educacion> buscarTodas() {
        return educacionService.listarEducacion();
    }

    
    @PreAuthorize("permitAll")
    @GetMapping("/educacion/{id}")
    @ResponseBody
    public Educacion obtenerEducacion(@PathVariable Long id) {
        return educacionService.obtenerEducacion(id);
    }

    @PreAuthorize("permitAll")
    @GetMapping("/educacion/titulo/{titulo}")
    @ResponseBody
    public List<Educacion> buscarPorTitulo(@PathVariable String titulo) {
        return educacionService.buscarEducacionPorTitulo(titulo);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/modifica/educacion")
    public void modificarEducacion(@RequestBody Educacion educacion) {
        educacionService.modificarEducacion(educacion);
        //  public ResponseEntity<Educacion> modificarEducacion(@RequestBody Educacion educacion) {
        //  educacionService.modificarEducacion(educacion);
        //  return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/educacion/update")

    public ResponseEntity<Educacion> updateEducacion(@RequestBody Educacion educacion) {
        Educacion updateEducacion = educacionService.updateEstudios(educacion);
        return new ResponseEntity<>(updateEducacion, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/educacion/{id}")
    public void borrarEducacion(@PathVariable Long id) {
        educacionService.borrarEducacion(id);
    }

}
