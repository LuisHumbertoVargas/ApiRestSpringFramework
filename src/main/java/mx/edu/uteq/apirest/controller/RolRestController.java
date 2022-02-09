
package mx.edu.uteq.apirest.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import mx.edu.uteq.apirest.dao.IRolDao;
import mx.edu.uteq.apirest.model.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/apirest")
public class RolRestController {
    
    @Autowired
    private IRolDao rolDao;
    
    @GetMapping("/roles")
    public List<Rol> listRoles() {
        return rolDao.findAll();
    }
    
    @GetMapping("/roles/{idRol}")
    public Rol getRol(@PathVariable Long idRol) {
        return rolDao.findById(idRol).orElse(null);
    }
    
    @PutMapping("/roles")
    public Rol putRol(@RequestBody Rol rol) {
        return rolDao.save(rol);
        
        
    }
    
    @PostMapping("/roles")
    public Rol postRol(@RequestBody Rol rol) {
        return rolDao.save(rol);
    }
    
    @DeleteMapping("/roles/{idRol}")
    public void deleteRol(@PathVariable Long idRol) {
        rolDao.deleteById(idRol);
    }
    
}
