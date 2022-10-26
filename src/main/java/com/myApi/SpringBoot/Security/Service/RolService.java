/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myApi.SpringBoot.Security.Service;

import com.myApi.SpringBoot.Security.Emuns.RolNombre;
import com.myApi.SpringBoot.Security.Entity.Rol;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myApi.SpringBoot.Security.Repository.iRolRepository;

/**
 *
 * @author EURO
 */
@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository iroleRepository;
    
    public Optional<Rol> getByRoleNombre(RolNombre roleNombre){
    return iroleRepository.findByRolNombre(roleNombre);
    }
    
    public void save(Rol role){
        iroleRepository.save(role);
    }
}
