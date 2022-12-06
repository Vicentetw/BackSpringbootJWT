
package com.myApi.SpringBoot.Repository;

import com.myApi.SpringBoot.Model.Experiencia;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia, Long>{
    public List<Experiencia> findByIdLike(int id);
    
}
