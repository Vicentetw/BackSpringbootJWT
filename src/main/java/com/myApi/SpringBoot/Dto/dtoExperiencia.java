/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myApi.SpringBoot.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author EURO
 */
public class dtoExperiencia {
   
    @NotBlank
    private String nombre_experiencia;
    @NotBlank
    private String duracion_experiencia;
    @NotBlank
    private String descripcion_experiencia;
    @NotBlank
    private int persona_id;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombre_experiencia, String duracion_experiencia, String descripcion_experiencia, int persona_id) {
        this.nombre_experiencia = nombre_experiencia;
        this.duracion_experiencia = duracion_experiencia;
        this.descripcion_experiencia = descripcion_experiencia;
        this.persona_id = persona_id;
    }

    
    
    public String getNombre_experiencia() {
        return nombre_experiencia;
    }

    public void setNombre_experiencia(String nombre_experiencia) {
        this.nombre_experiencia = nombre_experiencia;
    }

    public String getDuracion_experiencia() {
        return duracion_experiencia;
    }

    public void setDuracion_experiencia(String duracion_experiencia) {
        this.duracion_experiencia = duracion_experiencia;
    }

    public String getDescripcion_experiencia() {
        return descripcion_experiencia;
    }

    public void setDescripcion_experiencia(String descripcion_experiencia) {
        this.descripcion_experiencia = descripcion_experiencia;
    }

    public int getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    
    
}
