package edu.practica.reservahotel.repositories;

import edu.practica.reservahotel.models.Habitacion;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface HabitacionRepository extends R2dbcRepository<Habitacion, Long> {
    //Flux<Habitacion> findHabitacionesByNombreContainsIgnoreCaseByOrderByNombreAsc(String nombre);
}
