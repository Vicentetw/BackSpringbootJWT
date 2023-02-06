/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.myApi.SpringBoot.Security.Repository;

import com.myApi.SpringBoot.Security.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author EURO
 */
@Repository
public interface iUsuarioRepository extends JpaRepository<Usuario, Integer>{
    //Optional<Usuario> findByNombreUsuario(String nombre_usuario);
    Optional<Usuario> findByUserName(String userName);
    boolean existsByUserName(String userName);
    boolean existsByEmail(String email);
    
}
