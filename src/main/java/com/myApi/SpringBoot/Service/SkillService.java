/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myApi.SpringBoot.Service;

import com.myApi.SpringBoot.Model.Skill;
import com.myApi.SpringBoot.Repository.SkillRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SkillService implements ISkillService{
@Autowired
SkillRepository repositorioSkill;
 
public SkillService(SkillRepository repositorioSkill) {
        this.repositorioSkill = repositorioSkill;
}

@Override
    public void crearSkill(Skill skill) {
       repositorioSkill.save(skill);
    }
       @Override
    public void borrarSkill(Long id) {
       repositorioSkill.deleteById(id);
    }

    @Override
    public List<Skill> listarSkills() {

        return repositorioSkill.findAll();
    }

    public Skill obtenerSkill(Long id)
    {
        return repositorioSkill.findById(id).orElse(null);
    }

    public void modificarSkill(Skill skill)
    {
    repositorioSkill.save(skill);
    }



   
}
    

