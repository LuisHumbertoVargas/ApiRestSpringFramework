
package mx.edu.uteq.apirest.dao;

import mx.edu.uteq.apirest.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IRolDao extends JpaRepository<Rol, Long>{
    
}
