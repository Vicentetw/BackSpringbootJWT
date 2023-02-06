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
public class dtoEducacion {
    
   
    @NotBlank
    private String titulo;
    @NotBlank
    private String Institucion;
    @NotBlank
    private String fecha_egreso;
    @NotBlank
    private String fecha_inicio;
    @NotBlank
    private int persona_id;

    public dtoEducacion() {
    }

    public dtoEducacion( String titulo, String Institucion, String fecha_egreso, String fecha_inicio, int persona_id) {
        
        this.titulo = titulo;
        this.Institucion = Institucion;
        this.fecha_egreso = fecha_egreso;
        this.fecha_inicio = fecha_inicio;
        this.persona_id = persona_id;
    }



    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInstitucion() {
        return Institucion;
    }

    public void setInstitucion(String Institucion) {
        this.Institucion = Institucion;
    }

    public String getFecha_egreso() {
        return fecha_egreso;
    }

    public void setFecha_egreso(String fecha_egreso) {
        this.fecha_egreso = fecha_egreso;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public int getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    

   
   
}
