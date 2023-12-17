package edu.practica.reservahotel.controller;

import edu.practica.reservahotel.models.Habitacion;
import edu.practica.reservahotel.service.HabitacionService;
import edu.practica.reservahotel.service.HotelService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/habitaciones")
@AllArgsConstructor
public class HabitacionController {

    private HabitacionService habitacionService;

    private final Logger LOGGER = LoggerFactory.getLogger(HotelService.class);

    @GetMapping("/{id}")
    public Mono<Habitacion> consultarPorHabitacion(@PathVariable Long id) {
        return habitacionService.findById(id);
    }

    @GetMapping("/")
    public Flux<Habitacion> consultarHabitaciones() {
        return habitacionService.findAll();
    }

    @GetMapping("/status")
    public ResponseEntity<String> status() {
        return (ResponseEntity<String>) ResponseEntity.status(HttpStatus.OK);
    }
}