package edu.practica.reservahotel.service;

import edu.practica.reservahotel.models.Cliente;
import edu.practica.reservahotel.repositories.ClienteRepository;
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
public class ClienteService {

    private final Logger LOGGER = LoggerFactory.getLogger(HotelService.class);

    private final ClienteRepository clienteRepository;


    public Mono<Cliente> findById(Long id){
        return clienteRepository.findById(id)
                .onErrorResume(throwable -> {
                    LOGGER.error("Error al consultar un cliente con cedula= " + id, throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cliente con cedula= " + id + " no encontrado").getMostSpecificCause()));
    }

    public Flux<Cliente> findAll(){
        return clienteRepository.findAll()
                .onErrorResume(throwable -> {
                    LOGGER.error("Error al consultar todos los clientes", throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Ningún cliente encontrado").getMostSpecificCause()));
    }
}
