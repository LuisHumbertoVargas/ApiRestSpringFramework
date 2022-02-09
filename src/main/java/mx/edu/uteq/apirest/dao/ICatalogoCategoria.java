
package mx.edu.uteq.apirest.dao;

import mx.edu.uteq.apirest.model.CatalogoCategoria;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ICatalogoCategoria extends JpaRepository<CatalogoCategoria, Long> {
    
    public CatalogoCategoria findByCategoria(String categoria);
    
}
