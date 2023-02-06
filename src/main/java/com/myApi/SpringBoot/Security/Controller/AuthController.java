/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myApi.SpringBoot.Security.Controller;

import com.myApi.SpringBoot.Security.Dto.JwtDto;
import com.myApi.SpringBoot.Security.Dto.NuevoUsuario;
import com.myApi.SpringBoot.Security.Dto.LoginUsuario;
import com.myApi.SpringBoot.Security.Emuns.RolNombre;
import com.myApi.SpringBoot.Security.Entity.Rol;
import com.myApi.SpringBoot.Security.Entity.Usuario;

import com.myApi.SpringBoot.Security.Service.RolService;
import com.myApi.SpringBoot.Security.Service.UsuarioService;
import com.myApi.SpringBoot.Security.jwt.JwtProvider;


import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author EURO
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    RolService rolService;
    
    @Autowired
    JwtProvider jwtProvider;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/nuevoAdmin")
    public ResponseEntity<?> nuevoAdmin(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal puestos o email invalid"), HttpStatus.BAD_REQUEST);
        
        if(usuarioService.existsByUserName(nuevoUsuario.getUserName()))
            return new ResponseEntity(new Mensaje("Ese nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
        
        if(usuarioService.existsByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity(new Mensaje("Ese email ya existe"), HttpStatus.BAD_REQUEST);
        
        Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getUserName(),
            nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));
        
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRoleNombre(RolNombre.ROLE_USER).get());
        
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRoleNombre(RolNombre.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        
        return new ResponseEntity(new Mensaje("Usuario guardado"),HttpStatus.CREATED);
    }
    
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal puestos o email invalid"), HttpStatus.BAD_REQUEST);
        
        if(usuarioService.existsByUserName(nuevoUsuario.getUserName()))
            return new ResponseEntity(new Mensaje("Ese nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
        
        if(usuarioService.existsByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity(new Mensaje("Ese email ya existe"), HttpStatus.BAD_REQUEST);
        
        Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getUserName(),
            nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));
        
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRoleNombre(RolNombre.ROLE_USER).get());
        
        if(nuevoUsuario.getRoles().contains("user"))
            roles.add(rolService.getByRoleNombre(RolNombre.ROLE_USER).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        
        return new ResponseEntity(new Mensaje("Usuario guardado"),HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal puestos"), HttpStatus.BAD_REQUEST);
        
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
        loginUsuario.getUserName(), loginUsuario.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtProvider.generateToken(authentication);
        
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
   
    
}