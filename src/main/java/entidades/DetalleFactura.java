package entidades;

import javax.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;
import java.io.Serializable;

//Lombok
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//ENVERS
@Audited
//JPA
@Entity
@Table (name = "Detalles_Factura")

public class DetalleFactura implements Serializable {
    @Column(name = "Cantidad")
    private int cantidad;
    @Column(name = "Subtotal")
    private int subtotal;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="FK_Articulo")
    private Articulo articulo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_Factura")
    private Factura factura;

    public int calcularSubtotal(int precioArt, int cantidad) {
        return precioArt * cantidad;
    }
}
