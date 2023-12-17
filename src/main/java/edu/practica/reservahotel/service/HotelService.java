package edu.practica.reservahotel.service;

import edu.practica.reservahotel.dto.DTOHotelEntrada;
import edu.practica.reservahotel.exception.CreandoHotelException;
import edu.practica.reservahotel.models.Hotel;
import edu.practica.reservahotel.repositories.HotelRepository;
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
public class HotelService {

    private final Logger LOGGER = LoggerFactory.getLogger(HotelService.class);

    private final HotelRepository hotelRepository;

    public Mono<Hotel> crearHotel(DTOHotelEntrada dtoHotelEntrada){

        return Mono.just(Hotel.builder()
                .nombre(dtoHotelEntrada.nombre())
                .direccion(dtoHotelEntrada.direccion())
                .telefono(dtoHotelEntrada.telefono())
                .tipo(dtoHotelEntrada.tipo()).build()
                )
                .doOnNext(hotel -> LOGGER.info("Creando un hotel: {}", hotel))
                .flatMap(hotelRepository::save)
                .onErrorResume(error -> {
                    LOGGER.error(error.getMessage());
                    return Mono.error(new CreandoHotelException("Error creando hotel"));
                });
    }

    public Mono<Hotel> findById(Long id){
        return hotelRepository.findById(id)
                .onErrorResume(throwable -> {
                    LOGGER.error("Error al consultar un hotel con id= " + id, throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Hotel con id= " + id + " no encontrado").getMostSpecificCause()));
    }

    public Flux<Hotel> findAll(){
        return hotelRepository.findAll()
                .onErrorResume(throwable -> {
                    LOGGER.error("Error al consultar todos los hoteles", throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Ningún hotel encontrado").getMostSpecificCause()));
    }

    public Mono<Hotel> actualizarHotel(Long id, DTOHotelEntrada dtoHotelEntrada) {
        return findById(id)
                .doOnNext(hotel -> LOGGER.info("Se encontró el hotel: {}", hotel))
                .map(hotel -> Hotel.builder()
                        .id(hotel.getId())
                        .nombre(dtoHotelEntrada.nombre())
                        .direccion(dtoHotelEntrada.direccion())
                        .tipo(dtoHotelEntrada.tipo())
                        .telefono(dtoHotelEntrada.telefono())
                        .build())
                .doOnNext(hotel -> LOGGER.info("Se actualiza el hotel: {}", hotel))
                .flatMap(hotelRepository::save)
                .onErrorResume(error -> {
                    LOGGER.error(error.getMessage());
                    return Mono.error(new CreandoHotelException("Hotel no actualizado"));
                });
    }

    public Mono<Void> deleteAll(){
        return hotelRepository.deleteAll()
                .onErrorResume(throwable -> {
                    LOGGER.error("Error al eliminar todos los hoteles", throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Hoteles no eliminados").getMostSpecificCause()));
    }

    public Mono<Void> eliminarHotel(Long id) {
        return findById(id)
                .doOnNext(hotel -> LOGGER.info("Se encontró hotel: {}", hotel))
                .flatMap(hotelRepository::delete)
                .onErrorResume(error -> {
                    LOGGER.error("Error al eliminar un hotel con id= "+ id, error);
                    return Mono.empty();
                });
    }
}
