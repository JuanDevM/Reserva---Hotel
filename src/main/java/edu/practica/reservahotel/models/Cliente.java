package edu.practica.reservahotel.models;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Table("clientes_reservas")
@Builder
public class Cliente {
    @Id
    private Long id;

    @Column("documento")
    private String documento;

    @Column("celular")
    private String celular;

    @Column("nombre")
    private String nombre;

    @Column("direccion")
    private String direccion;

    @Column("correo")
    private String correo;

    /*
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "idreserva",
            referencedColumnName = "idreserva"
    )*/
    //private Reserva reserva;
}
