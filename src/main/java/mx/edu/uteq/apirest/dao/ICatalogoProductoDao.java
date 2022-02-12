
package mx.edu.uteq.apirest.dao;

import java.util.List;
import mx.edu.uteq.apirest.model.CatalogoProducto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ICatalogoProductoDao extends JpaRepository<CatalogoProducto, Long> {
    
    public List<CatalogoProducto> findAllByPrecio(double precio); 
    
}
