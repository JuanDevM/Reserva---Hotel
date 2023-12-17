package edu.practica.reservahotel.service;

import edu.practica.reservahotel.models.Habitacion;
import edu.practica.reservahotel.repositories.HabitacionRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@AllArgsConstructor
public class HabitacionService {

    private final Logger LOGGER = LoggerFactory.getLogger(HotelService.class);

    private final HabitacionRepository habitacionRepository;


    public Mono<Habitacion> findById(Long id){
        return habitacionRepository.findById(id)
                .onErrorResume(throwable -> {
                    LOGGER.error("Error al consultar una habitación con cedula= " + id, throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "habitación con id= " + id + " no encontrado").getMostSpecificCause()));
    }

    public Flux<Habitacion> findAll(){
        return habitacionRepository.findAll()
                .onErrorResume(throwable -> {
                    LOGGER.error("Error al consultar todos las habitaciones", throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Ningúna habitación encontrada").getMostSpecificCause()));
    }
}

