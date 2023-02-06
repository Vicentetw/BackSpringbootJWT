
package com.myApi.SpringBoot.Model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Educacion {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    private String titulo;
    private String institucion;
    private String fecha_egreso;
    private String fecha_inicio;
    private int persona_id;

    public Educacion() {
    }

    public Educacion(Long id, String titulo, String institucion, String fecha_egreso, String fecha_inicio, int persona_id) {
        this.id = id;
        this.titulo = titulo;
        this.institucion = institucion;
        this.fecha_egreso = fecha_egreso;
        this.fecha_inicio = fecha_inicio;
        this.persona_id = persona_id;
    }

   /* public Educacion(String titulo, String institucion, String fecha_egreso, String fecha_inicio, int persona_id) {
        this.titulo = titulo;
        this.institucion = institucion;
        this.fecha_egreso = fecha_egreso;
        this.fecha_inicio = fecha_inicio;
        this.persona_id = persona_id;
    }*/
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
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

    @Override
    public String toString() {
        return "Educacion{" + "id=" + id + ", titulo=" + titulo + ", institucion=" + institucion + ", fecha_egreso=" + fecha_egreso + ", fecha_inicio=" + fecha_inicio + ", persona_id=" + persona_id + '}';
    }

    

    
}
