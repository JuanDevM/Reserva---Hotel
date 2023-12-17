package edu.practica.reservahotel.service;

import edu.practica.reservahotel.models.Reserva;
import edu.practica.reservahotel.repositories.ReservaRepository;
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
public class ReservaService {

    private final Logger LOGGER = LoggerFactory.getLogger(HotelService.class);

    private final ReservaRepository reservaRepository;


    public Mono<Reserva> findById(Long id){
        return reservaRepository.findById(id)
                .onErrorResume(throwable -> {
                    LOGGER.error("Error al consultar la reserva= " + id, throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Reserva= " + id + " no encontrada").getMostSpecificCause()));
    }

    public Flux<Reserva> findAll(){
        return reservaRepository.findAll()
                .onErrorResume(throwable -> {
                    LOGGER.error("Error al consultar todos las reservas", throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Ningúna reserva encontrada").getMostSpecificCause()));
    }
}
