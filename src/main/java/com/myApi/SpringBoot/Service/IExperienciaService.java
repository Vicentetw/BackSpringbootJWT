
package com.myApi.SpringBoot.Service;

import com.myApi.SpringBoot.Model.Experiencia;
import java.util.List;


public interface IExperienciaService {
    public void crearExperiencia (Experiencia experiencia);
    public void borrarExperiencia (Long id);
    public List <Experiencia> listarExperiencias();
 
}
