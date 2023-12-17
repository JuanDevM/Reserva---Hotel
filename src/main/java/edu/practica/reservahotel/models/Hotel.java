package edu.practica.reservahotel.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("hotel_reservas")
@Builder
public class Hotel implements TipoHotelDisponibleInterface {
    @Id
    private Long id;

    @Column("nombre")
    private String nombre;

    @Column("direccion")
    private String direccion;

    @Column("telefono")
    private String telefono;

    @Column("tipo")
    private String tipo;

    @Override
    public String getTipoHotelDisponible() {
        return "Este es el tipo de hotel disponible: ".concat(this.getTipo());
    }

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
