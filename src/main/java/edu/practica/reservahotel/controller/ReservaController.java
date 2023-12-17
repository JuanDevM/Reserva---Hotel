package edu.practica.reservahotel.controller;

import edu.practica.reservahotel.models.Reserva;
import edu.practica.reservahotel.service.HotelService;
import edu.practica.reservahotel.service.ReservaService;
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
@RequestMapping("/reservas")
@AllArgsConstructor
public class ReservaController {

    private ReservaService reservaService;

    private final Logger LOGGER = LoggerFactory.getLogger(HotelService.class);

    @GetMapping("/{id}")
    public Mono<Reserva> consultarPorReserva(@PathVariable Long id){
        return reservaService.findById(id);
    }

    @GetMapping("/")
    public Flux<Reserva> consultarReservas(){
        return reservaService.findAll();
    }

    @GetMapping("/status")
    public ResponseEntity<String> status() {
        return (ResponseEntity<String>) ResponseEntity.status(HttpStatus.OK);
    }
}