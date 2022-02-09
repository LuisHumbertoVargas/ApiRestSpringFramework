
package mx.edu.uteq.apirest.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class CatalogoProducto implements Serializable {
    
    static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCatalogoProducto;
    
    @NotEmpty
    private String producto;
    
    @NotNull
    @Min(0)
    private double precio;
    private boolean activo;
    
    @Column(name = "ult_modifica")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultModifica;
    
    @PrePersist
    public void prePersist() {
        ultModifica = new Date();
    }
    
}
