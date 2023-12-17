package edu.practica.reservahotel.repositories;

import edu.practica.reservahotel.models.Cliente;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface ClienteRepository extends R2dbcRepository<Cliente, Long> {
    //Flux<Cliente> findClientesByNombreContainsIgnoreCaseByOrderByNombreAsc(String nombre);
}
