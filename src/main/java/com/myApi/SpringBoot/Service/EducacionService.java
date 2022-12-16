/*Perrotta Vicente grupo 141*/
package com.myApi.SpringBoot.Service;

import com.myApi.SpringBoot.Model.Educacion;
import com.myApi.SpringBoot.Repository.EducacionRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class EducacionService implements IEducacionService{

 @Autowired
 EducacionRepository repositorioEducacion;
 
 
 public EducacionService(EducacionRepository repositorioEducacion) {
        this.repositorioEducacion = repositorioEducacion;
    }
 
  @Override
    public void crearEducacion(Educacion educacion) {
         repositorioEducacion.save(educacion);
    }
    
  public Educacion obtenerEducacion(Long id)
    {
        return repositorioEducacion.findById(id).orElse(null);
    }

 @Override
    public List<Educacion> listarEducacion() {

        return repositorioEducacion.findAll();
    }
 
    public void addEducacion(Educacion educacion) {
        repositorioEducacion.save(educacion);
    }
   

 @Override
    public void borrarEducacion(Long id) {
        repositorioEducacion.deleteById(id);
    }
   public Educacion updateEstudios(Educacion educacion) {
        return repositorioEducacion.save(educacion);
    }
    
   public void modificarEducacion(Educacion educacion)
    {
    repositorioEducacion.save(educacion);
    }
   public List<Educacion> buscarEducacionPorTitulo(String titulo)
{
return repositorioEducacion.findByTituloLike(titulo);
}

   public boolean existsByTitulo(String titulo){
   return repositorioEducacion.existsByTitulo(titulo);
           }

 
}
