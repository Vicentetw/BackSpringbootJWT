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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*@CrossOrigin(origins = {"https://portfolio-angular-81057.web.app/"})*/
@CrossOrigin(origins = "*")
public class EducacionController {

    @Autowired
    EducacionService educacionService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/educacion")
    public void crearEducacion(@RequestBody Educacion educacion) {
        educacionService.crearEducacion(educacion);
    }

    /*Método GET*/
    @GetMapping("/educacion/all")
    public ResponseEntity<List<Educacion>> getAllEstudios() {
        List<Educacion> educacion = educacionService.listarEducacion();
        return new ResponseEntity<>(educacion, HttpStatus.OK);
    }

    @GetMapping("/educacion2/all")
    @ResponseBody
    public List<Educacion> buscarTodas() {
        return educacionService.listarEducacion();
    }

    @GetMapping("/educacion")
    public String saludar(@RequestParam String titulo) {
        return "El nombre del título es: " + titulo;
    }

    @GetMapping("/educacion/{id}")
    @ResponseBody
    public Educacion obtenerEducacion(@PathVariable Long id) {
        return educacionService.obtenerEducacion(id);
    }

    @GetMapping("/educacion/titulo/{titulo}")
    @ResponseBody
    public List<Educacion> buscarPorTitulo(@PathVariable String titulo) {
        return educacionService.buscarEducacionPorTitulo(titulo);
    }

    /*Método PUT*/
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/modifica/educacion")
    public void modificarEducacion(@RequestBody Educacion educacion) {
        educacionService.modificarEducacion(educacion);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/educacion/update")
    public ResponseEntity<Educacion> updateEducacion(@RequestBody Educacion educacion) {
        Educacion updateEducacion = educacionService.updateEstudios(educacion);
        return new ResponseEntity<>(updateEducacion, HttpStatus.OK);
    }

    /*Método DELETE I use "preautorize" to request a role to execute the method*/
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/educacion/{id}")
    public void borrarEducacion(@PathVariable Long id) {
        educacionService.borrarEducacion(id);
    }

}
