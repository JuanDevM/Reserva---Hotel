package edu.practica.reservahotel.repositories;

import edu.practica.reservahotel.models.Hotel;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface HotelRepository extends R2dbcRepository<Hotel, Long> {

    //Flux<Hotel> findHotelesByNombreContainsIgnoreCaseByOrderByNombreAsc(String nombre);
}
