/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.myApi.SpringBoot.Security.Repository;


import com.myApi.SpringBoot.Security.Emuns.RolNombre;
import com.myApi.SpringBoot.Security.Entity.Rol;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author EURO
 */
@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
     Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
