package edu.practica.reservahotel.controller;

import edu.practica.reservahotel.models.Hotel;
import edu.practica.reservahotel.service.HotelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HotelControllerTest {

    @Mock
    private HotelService hotelService;

    private HotelController hotelController;

    @BeforeEach
    public void setUp(){
        hotelController = new HotelController(hotelService);
    }

    @Test
    void testConsultarHotelesExitoso(){

        // Arrange
        String nombre = "Belfort";
        Hotel hotel = Hotel.builder().nombre(nombre).build();
        when(hotelService.findAll()).thenReturn(Flux.just(hotel));

        // Act
        Flux<Hotel> hotelesResult = hotelController.consultarHoteles();

        // Assert
        StepVerifier.create(hotelesResult)
                .expectNextMatches(hotel1 -> {
                    assert hotel1.getNombre().equals(nombre);
                    return true;
                })
                .verifyComplete();

    }

    @Test
    void testObtenerUnHotel() {
        // Arrange
        Long id = 1L;
        String nombre = "Belfort";
        Hotel hotel = Hotel.builder().nombre(nombre).build();
        when(hotelService.findById(id)).thenReturn(Mono.just(hotel));

        // Act
        Mono<Hotel> hotelResult = hotelController.consultarPorHotel(id);

        // Assert
        StepVerifier.create(hotelResult)
                .expectNextMatches(hotel1 -> {
                    assert hotel1.getNombre().equals(nombre);
                    return true;
                })
                .verifyComplete();

    }
}
