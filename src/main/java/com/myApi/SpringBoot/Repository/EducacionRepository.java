
package com.myApi.SpringBoot.Repository;

import com.myApi.SpringBoot.Model.Educacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
 public interface EducacionRepository extends JpaRepository<Educacion, Long>{
    public List<Educacion> findByTituloLike(String  titulo);
    public boolean existsByTitulo(String titulo);    
}
