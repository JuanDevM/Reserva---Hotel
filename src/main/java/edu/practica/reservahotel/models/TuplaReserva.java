package edu.practica.reservahotel.models;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class TuplaReserva<K, V> {
    private K reserva;
    private V reservas;
}