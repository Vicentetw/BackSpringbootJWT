/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myApi.SpringBoot.Security.Entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author EURO
 */
public class UsuarioPrincipal implements UserDetails {

    private String nombre;
    private String userName;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public UsuarioPrincipal() {
    }

    public UsuarioPrincipal(String nombre, String userName, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.nombre = nombre;
        this.userName= userName;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static UsuarioPrincipal build(Usuario usuario) {
        List<GrantedAuthority> authorities = usuario.getRoles()
                .stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name()))
                .collect(Collectors.toList());
        return new UsuarioPrincipal(usuario.getNombre(), usuario.getUsername(), usuario.getEmail(),
                usuario.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

}
