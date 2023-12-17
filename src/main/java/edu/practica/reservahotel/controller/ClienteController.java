package edu.practica.reservahotel.controller;

import edu.practica.reservahotel.models.Cliente;
import edu.practica.reservahotel.service.ClienteService;
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
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {

    private ClienteService clienteService;

    private final Logger LOGGER = LoggerFactory.getLogger(HotelService.class);

    @GetMapping("/{id}")
    public Mono<Cliente> consultarPorCliente(@PathVariable Long id){
        return clienteService.findById(id);
    }

    @GetMapping("/")
    public Flux<Cliente> consultarClientes(){
        return clienteService.findAll();
    }

    @GetMapping("/status")
    public ResponseEntity<String> status() {
        return (ResponseEntity<String>) ResponseEntity.status(HttpStatus.OK);
    }
}