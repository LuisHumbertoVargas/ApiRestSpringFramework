
package mx.edu.uteq.apirest.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import mx.edu.uteq.apirest.dao.ICatalogoCategoria;
import mx.edu.uteq.apirest.model.CatalogoCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/apirest")
public class CatalogoCategoriaRestController {
    
    @Autowired
    private ICatalogoCategoria categoriaDao;
    
    @GetMapping("/catalogo-categorias")
    public List<CatalogoCategoria> list() {
        return categoriaDao.findAll();
    }
    
    @GetMapping("/catalogo-categorias/{id}")
    public CatalogoCategoria get(@PathVariable Long id) {
        return categoriaDao.findById(id).orElse(null);
    }
    
    @PutMapping("/catalogo-categorias/{id}")
    public ResponseEntity<CatalogoCategoria> put(@PathVariable Long id, @RequestBody CatalogoCategoria categoria) {
        
        CatalogoCategoria cActual = categoriaDao.findById(id).orElse(null);
        
        if (cActual == null) {
            return new ResponseEntity<>(cActual, HttpStatus.NOT_FOUND);
        }
        
        //cActual.setCategoria(categoria.getCategoria());
        //);
        
        return null;
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody CatalogoCategoria input) {
        return null;
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }
    
}
