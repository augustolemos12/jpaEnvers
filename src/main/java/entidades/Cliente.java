package entidades;

import javax.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
@Table(name = "Clientes")

public class Cliente implements Serializable {
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellido")
    private String apellido;
    @Column(name = "DNI")
    private int dni;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "cliente")
    @Builder.Default
    private List<Factura> facturas = new ArrayList<Factura>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_Domicilio")
    private Domicilio domicilio;

}
