/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myApi.SpringBoot.Security.Service;

import com.myApi.SpringBoot.Security.Entity.Usuario;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myApi.SpringBoot.Security.Repository.iUsuarioRepository;

/**
 *
 * @author EURO
 */
@Service
@Transactional
public class UsuarioService {
    @Autowired
    iUsuarioRepository userRepository;

    public Optional<Usuario> getByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public boolean existsByUserName(String userName){
        return userRepository.existsByUserName(userName);
    }

    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public void save(Usuario user) {
        userRepository.save(user);
    }
}
