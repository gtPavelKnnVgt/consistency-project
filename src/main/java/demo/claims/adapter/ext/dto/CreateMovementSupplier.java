package demo.claims.adapter.ext.dto;

import demo.claims.app.api.CreateMovementOutbound;
import demo.claims.domain.FinancialClaim;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.List;
import java.util.function.Supplier;

@Component
@RequiredArgsConstructor
@Slf4j
public class CreateMovementSupplier implements CreateMovementOutbound {
    private final Sinks.Many<Message<CreateMovementsDto>> sinks = Sinks.many().unicast().onBackpressureBuffer();
    private final MovementDtoMapper mapper;

    @Bean
    public Supplier<Flux<Message<CreateMovementsDto>>> claimsCreatedEvent() {
        return sinks::asFlux;
    }

    @Override
    public void createMovements(List<FinancialClaim> claims) {
        log.info("Sending claims info for movements creation");
        CreateMovementsDto dto = mapper.mapToDto(claims);
        Message<CreateMovementsDto> message = MessageBuilder.withPayload(dto)
                .build();
        sinks.tryEmitNext(message);
    }
}
