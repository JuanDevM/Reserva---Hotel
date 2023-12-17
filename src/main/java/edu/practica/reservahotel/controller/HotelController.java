package edu.practica.reservahotel.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.practica.reservahotel.dto.DTOHotelEntrada;
import edu.practica.reservahotel.models.Hotel;
import edu.practica.reservahotel.service.HotelService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/hoteles")
@AllArgsConstructor
public class HotelController {

    private HotelService hotelService;

    private final Logger LOGGER = LoggerFactory.getLogger(HotelService.class);

    @PostMapping("/")
    public Mono<Hotel> crearHotel(@RequestBody DTOHotelEntrada dtoHotelEntrada) throws JsonProcessingException {

        return Mono.just(dtoHotelEntrada)
                .doOnNext(dtoHotel -> LOGGER.info("Creando hotel: {}", dtoHotel))
                .flatMap(hotelService::crearHotel)
                .doOnNext(hotel -> LOGGER.info("Hotel creado: {}", hotel))
                .doOnError(error ->LOGGER.error("Error creando hotel: {}", error.getMessage()));
    }


   @GetMapping("/{id}")
    public Mono<Hotel> consultarPorHotel(@PathVariable Long id){
        return hotelService.findById(id);
    }

    @GetMapping("/")
    public Flux<Hotel> consultarHoteles(){
        return hotelService.findAll();
    }

    @PutMapping("/{id}")
    public Mono<Hotel> actualizarHotel(@PathVariable Long id, @RequestBody  DTOHotelEntrada dtoHotelEntrada) {
        return Mono.just(dtoHotelEntrada)
                .doOnNext(dtoHotel -> LOGGER.info("Actualizando hotel: {}", dtoHotel))
                .flatMap(dtoHotel -> hotelService.actualizarHotel(id, dtoHotel))
                .doOnNext(hotel -> LOGGER.info("Hotel actualizado: {}", hotel))
                .doOnError(error ->LOGGER.error("Error actualizando Hotel: {}", error.getMessage()));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> eliminarHotel(@PathVariable Long id) {
        return hotelService.eliminarHotel(id);
    }


    @DeleteMapping
    public Mono<Void> eliminarHoteles(){
        return hotelService.deleteAll();
    }

    @GetMapping("/status")
    public ResponseEntity<String> status() {
        return (ResponseEntity<String>) ResponseEntity.status(HttpStatus.OK);
    }
}
