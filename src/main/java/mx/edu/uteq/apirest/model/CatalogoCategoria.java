
package mx.edu.uteq.apirest.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.Data;


@Data
@Entity
@Table(name = "catalogo_categoria")
public class CatalogoCategoria implements Serializable{
    
    static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_categoria")
    private Long idCategoria;
    
    @Size(max = 45)
    @Column(name = "categoria")
    private String categoria;
    
    // Si quiero que de la tabla categoria tomar todos los productos es así:
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_categoria")
    private List<CatalogoProducto> catalogoProductoList;
    
}
