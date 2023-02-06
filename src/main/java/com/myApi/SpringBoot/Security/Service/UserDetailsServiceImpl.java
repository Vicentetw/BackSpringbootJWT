/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myApi.SpringBoot.Security.Service;


import com.myApi.SpringBoot.Security.Entity.UsuarioPrincipal;
import com.myApi.SpringBoot.Security.Entity.Usuario;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;



import org.springframework.stereotype.Service;


/**
 *
 * @author EURO
 */
@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UsuarioService userService;

    @Override
    public UserDetails loadUserByUsername(String userName)throws UsernameNotFoundException {
        Usuario user = userService.getByUserName(userName).get();
        return UsuarioPrincipal.build(user);
    }
    
}
