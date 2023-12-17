package edu.practica.reservahotel.service;

import edu.practica.reservahotel.config.kafka.KafkaConfig;
import edu.practica.reservahotel.models.Reserva;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.TopicPartitionOffset;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service
public class ReservaServiceKafkaConsumer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public String obtenerReservaKafka(String topico){
        ConsumerRecord<String, String> reservaRealizada;
        KafkaConfig kafkaConfig = new KafkaConfig();
        kafkaTemplate.setConsumerFactory(kafkaConfig.consumerFactory());
        reservaRealizada = kafkaTemplate.receive(topico, 0, 0);
        return Objects.requireNonNull(reservaRealizada.value());
    }

    public Flux<Reserva> obtenerReservaDesdeKafka(String topico){
        ConsumerRecords<String, String> resevasRealizadas;
        KafkaConfig kafkaConfig = new KafkaConfig();
        kafkaTemplate.setConsumerFactory(kafkaConfig.consumerFactory());
        resevasRealizadas = kafkaTemplate.receive(List.of(new TopicPartitionOffset(topico, 0)));
        return convertirReservasDesdeKafkaHaciaReserva(resevasRealizadas);
    }

    private Flux<Reserva> convertirReservasDesdeKafkaHaciaReserva(ConsumerRecords<String, String> reservasRecibidas){
        List<Reserva> reservas = new LinkedList<>();
        for(ConsumerRecord<String, String> consumerRecord : reservasRecibidas){
            reservas.add(Reserva.convertirStringAReserva(consumerRecord.value()));
        }

        return (Flux<Reserva>) reservas;
    }
}