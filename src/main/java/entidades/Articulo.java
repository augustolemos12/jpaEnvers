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
@Table(name = "Articulos")

public class Articulo implements Serializable {
    @Column(name = "Cantidad")
    private int cantidad;
    @Column(name = "Denominacion")
    private String denominacion;
    @Column(name = "Precio")
    private int precio;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "Articulo_Categoria", joinColumns = @JoinColumn(name = "articulo_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    @Builder.Default
    private List<Categoria> categorias = new ArrayList<Categoria>();

    @OneToMany(mappedBy = "articulo")
    @Builder.Default
    private List<DetalleFactura> detalleFacturas = new ArrayList<DetalleFactura>();
}
