package edu.practica.reservahotel.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("habitacion_reservas")
@Builder
public class Habitacion implements TipoHabitacionDisponible{
    @Id
    private Long id;

    @Column("codigoHabitacion")
    private String codigoHabitacion;

    @Column("tipoHabitacion")
    private String tipoHabitacion;

    @Override
    public String getTipoHabitacionlDisponible() {
        return "Este es el tipo de hotel disponible: ".concat(this.getTipoHabitacion());
    }
}
