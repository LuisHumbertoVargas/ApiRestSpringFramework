
package mx.edu.uteq.apirest.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "catalogo_producto")
public class CatalogoProducto implements Serializable {
    
    static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long idCatalogoProducto;
    
    @NotEmpty
    @Size(max = 45)
    @Column(name = "producto")
    private String producto;
    
    @NotNull
    @Min(0)
    @Column(name = "precio")
    private double precio;
    private boolean activo;
    
    @Column(name = "ult_modifica")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultModifica;
    
    //@PrePersist
    //public void prePersist() {
        //ultModifica = new Date();
    //}
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "idCategoria")
    private CatalogoCategoria categoria;
    
    
    
    
}
