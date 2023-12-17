package edu.practica.reservahotel.repositories;

import edu.practica.reservahotel.models.Reserva;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface ReservaRepository extends R2dbcRepository<Reserva, Long> {
    //Flux<Reserva> findReservasByNombreContainsIgnoreCaseByOrderByNombreAsc(String nombre);
}
