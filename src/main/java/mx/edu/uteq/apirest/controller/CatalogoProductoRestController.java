
package mx.edu.uteq.apirest.controller;

import java.util.Date;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import mx.edu.uteq.apirest.dao.ICatalogoProductoDao;
import mx.edu.uteq.apirest.model.CatalogoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping("/apirest")
public class CatalogoProductoRestController {
    
    @Autowired
    private ICatalogoProductoDao catProductoDao;
    
    @GetMapping("/catalogo-productos")
    public List<CatalogoProducto> listCatalogoProducto() {
        return catProductoDao.findAll();
    }
    
    @GetMapping("/catalogo/{idCatalogoProductos}")
    public CatalogoProducto getCatalgoProductos(@PathVariable Long idCatalogoProducto) {
        return catProductoDao.findById(idCatalogoProducto).orElse(null);
    }
    
    @PutMapping("/catalogo-productos/{id}")
    public ResponseEntity<CatalogoProducto> put(@PathVariable Long id, @RequestBody CatalogoProducto catalogo) {
        
        CatalogoProducto cActual = catProductoDao.findById(id).orElse(null);
        
        if (cActual == null) {
           return new ResponseEntity<>(cActual, HttpStatus.NOT_FOUND);
        }
        
        cActual.setProducto(catalogo.getProducto());    
        cActual.setPrecio(catalogo.getPrecio());
        cActual.setActivo(catalogo.isActivo());
        cActual.setUltModifica(new Date());
        
        CatalogoProducto catalogoModificado = catProductoDao.save(cActual);
        HttpStatus statusGenerado = HttpStatus.CREATED;
        
        return new ResponseEntity<>(catalogoModificado, statusGenerado);
    }
    
    @PostMapping("/catalogo-productos")
    public ResponseEntity<CatalogoProducto> post(@RequestBody CatalogoProducto catalogo) {
        return new ResponseEntity<>(catProductoDao.save(catalogo), HttpStatus.CREATED);
    }
    
    //Manera 2 de hacer el post 
    //@PostMapping("/catalogo-productos")
    //@ResponseStatus(HttpStatus.CREATED)
    //public CatalogoProducto postCatalogoProductos(@RequestBody CatalogoProducto catalogo) {
        //return catProductoDao.save(catalogo);
    //}
    
    @DeleteMapping("/catalogo-productos/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        catProductoDao.deleteById(id);
        return new ResponseEntity<>("Eliminado", HttpStatus.OK);
    }
    
}
