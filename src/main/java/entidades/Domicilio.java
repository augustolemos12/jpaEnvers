package entidades;

import java.io.Serializable;
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
@Table(name = "Domicilios")

public class Domicilio implements Serializable {
    @Column(name = "Nombre_Calle")
    private String nombreCalle;
    @Column(name = "Numero")
    private int numero;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "domicilio")
    private Cliente cliente;
}
