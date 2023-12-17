package edu.practica.reservahotel.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Table("reserva_hotel")
@Builder
public class Reserva {
    @Id
    private Long id;

    @Column("idhotel")
    private Long idhotel;

    @Column("idhabitacion")
    private Long idhabitacion;

    @Column("cedulareserva")
    private String cedulareserva;

    @Column("fechainicioReserva")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechainicioReserva;

    @Column("fechafinReserva")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechafinReserva;

    @Column("valor")
    private BigDecimal valor;

    @Column("estado")
    private String estado;

    /*
    @ManyToOne(
            cascade = CascadeType.ALL
    )


    @JoinColumn(
            name = "documento",
            referencedColumnName = "documento"
    )

    private Cliente cliente;



    @ManyToOne(
            cascade = CascadeType.ALL
    )


    @JoinColumn(
            name = "id",
            referencedColumnName = "id"
    )

    private Hotel hotel;

    */

    public static Reserva convertirStringAReserva(String reservaEnString){
        Reserva reserva = null;
        reserva.setIdhabitacion(Long.valueOf(Integer.valueOf(reservaEnString.split("'Idhabitacion':")[1].split(", 'Idhotel':")[0])));
        reserva.setIdhotel(Long.valueOf(Integer.valueOf(reservaEnString.split("'Idhotel':")[1].split(", 'Cedulareserva':")[0])));
        reserva.setCedulareserva(reservaEnString.split("'Cedulareserva':")[1].split(", 'Estado':")[0].replace("'",""));
        reserva.setEstado(reservaEnString.split("'Estado':")[1].split(", 'Valor':")[0].replace("'",""));
        reserva.setValor(BigDecimal.valueOf(Long.valueOf(Integer.valueOf(reservaEnString.split("'Valor':")[1].split(", 'FechainicioReserva':")[0]))));
        reserva.setFechainicioReserva(LocalDate.ofEpochDay(Long.valueOf(Integer.valueOf(reservaEnString.split("'FechainicioReserva':")[1].split(", 'FechafinReserva':")[0]))));
        reserva.setFechafinReserva(LocalDate.ofEpochDay(Long.valueOf(Integer.valueOf(reservaEnString.split("'FechafinReserva':")[1]))));
        return reserva;
    }
}
