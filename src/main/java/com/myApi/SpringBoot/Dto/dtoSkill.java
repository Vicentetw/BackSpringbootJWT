/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myApi.SpringBoot.Dto;

/**
 *
 * @author EURO
 */
public class dtoSkill {

    private String nombre_skill;
    private int porcentaje_skill;
    private int persona_id; 

    public dtoSkill() {
    }

    public dtoSkill(String nombre_skill, int porcentaje_skill, int persona_id) {
       
        this.nombre_skill = nombre_skill;
        this.porcentaje_skill = porcentaje_skill;
        this.persona_id = persona_id;
    }

    

    public String getNombre_skill() {
        return nombre_skill;
    }

    public void setNombre_skill(String nombre_skill) {
        this.nombre_skill = nombre_skill;
    }

    public int getPorcentaje_skill() {
        return porcentaje_skill;
    }

    public void setPorcentaje_skill(int porcentaje_skill) {
        this.porcentaje_skill = porcentaje_skill;
    }

    public int getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    
}
