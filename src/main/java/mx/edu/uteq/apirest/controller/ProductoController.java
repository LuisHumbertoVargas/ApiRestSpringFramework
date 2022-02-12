
package mx.edu.uteq.apirest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Controller
public class ProductoController {
    
    @RequestMapping("/productos")
    public String page(Model model) {
        model.addAttribute("attribute", "value");
        return "productos.producto";
    }
    
    @ExceptionHandler({Exception.class})
    public String databaseError() {
        return "error-view-name";
    }
    
}
