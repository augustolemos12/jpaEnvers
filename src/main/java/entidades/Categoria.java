package entidades;
import javax.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
//Lombok
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
//ENVERS
@Audited
//JPA
@Entity
@Table(name = "Categorias")

public class Categoria implements Serializable {
    @Column(name = "Denominacion")
    private String denominacion;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "categorias")
    @Builder.Default
    private List<Articulo> articulos = new ArrayList<Articulo>();
}
