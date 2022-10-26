/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myApi.SpringBoot.Controller;

import com.myApi.SpringBoot.Model.Skill;
import com.myApi.SpringBoot.Service.SkillService;
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
public class SkillController {
    @Autowired
    SkillService skillService;

     /*Método PUT I use "preautorize" to request a role to execute the method */
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/skill")
    public void crearSkill(@RequestBody Skill skill) {
        skillService.crearSkill(skill);
    }

    @GetMapping("/skill/{id}")
    @ResponseBody
    public Skill obtenerSkill(@PathVariable Long id) {
        return skillService.obtenerSkill(id);
    }
    
    @GetMapping("/skill/todas")
    @ResponseBody
    public List<Skill> buscarTodas()
    {
    return skillService.listarSkills();
    }
    
     /*Método PUT I use "preautorize" to request a role to execute the method */
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/skill/{id}")
    public void borrarSkill(@PathVariable Long id) {
        skillService.borrarSkill(id);
    }

     /*Método PUT I use "preautorize" to request a role to execute the method */
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/modifica/skill")
    public void modificarSkill(@RequestBody Skill skill) {
        skillService.modificarSkill(skill);
    }

        
}
