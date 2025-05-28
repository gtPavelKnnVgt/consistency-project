package demo.claims.adapter.ext;

import demo.claims.adapter.ext.dto.FinancialClaimDomainMapper;
import demo.claims.adapter.ext.dto.FinancialClaimsInitiatedDto;
import demo.claims.app.api.CreateFinancialClaimInbound;
import demo.claims.app.api.CreateMovementOutbound;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@Slf4j
public class FinancialClaimInitiateListener {
    private final Counter rpsCounter;
    private final CreateFinancialClaimInbound createFinancialClaimInbound;
    private final FinancialClaimDomainMapper mapper;

    public FinancialClaimInitiateListener(MeterRegistry registry, CreateFinancialClaimInbound createFinancialClaimInbound,
                                          FinancialClaimDomainMapper mapper) {
        this.rpsCounter = Counter.builder("kafka.rps")
                .description("Kafka requests per second")
                .register(registry);
        this.createFinancialClaimInbound = createFinancialClaimInbound;
        this.mapper = mapper;
    }

    @Bean
    public Consumer<Message<FinancialClaimsInitiatedDto>> extFinancialClaimsInitiatedEvent() {
        return message -> {
            log.info("Received payload: {}", message.getPayload());
            rpsCounter.increment();
            FinancialClaimsInitiatedDto payload = message.getPayload();
            createFinancialClaimInbound.createBatch(mapper.mapToDomain(payload.getClaimsInfo()));
        };
    }
}
