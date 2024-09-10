package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

//Lombok
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//ENVERS
@Audited
//JPA
@Entity
@Table(name = "Facturas")

public class Factura implements Serializable {
    @Column(name = "Fecha")
    private String fecha;
    @Column(name = "Numero")
    private int numero;
    @Column(name = "Total")
    private int total;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<DetalleFactura> detalleFacturas = new ArrayList<DetalleFactura>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_Cliente")
    private Cliente cliente;
}
