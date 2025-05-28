package demo.claims.app.api.impl;

import demo.claims.app.api.CreateFinancialClaimInbound;
import demo.claims.app.api.FinancialClaimRepository;
import demo.claims.domain.*;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class CreateFinancialClaimUseCase implements CreateFinancialClaimInbound {
    private final FinancialClaimRepository claimRepository;
    private final FinancialClaimValidator validator;
    private final Timer businessTimer;
    private final Counter errorCounter;

    public CreateFinancialClaimUseCase(FinancialClaimRepository claimRepository, FinancialClaimValidator validator,
                                       MeterRegistry registry) {
        this.claimRepository = claimRepository;
        this.validator = validator;
        this.businessTimer = Timer.builder("business.function.timer")
                .description("Time taken to process business function")
                .publishPercentileHistogram(true) // Включает гистограмму для персентилей
                .register(registry);
        this.errorCounter = Counter.builder("business.function.errors")
                .description("Number of errors in business function")
                .register(registry);
    }


    @Override
    @Transactional
    public void create(FinancialClaim financialClaim) {
        claimRepository.save(financialClaim);
    }

    @Override
    @Transactional
    public void createBatch(List<FinancialClaim> financialClaims) {
        businessTimer.record(() -> {
            log.info("Creating financial claims... ");
            try {
                validator.validate(financialClaims);
                financialClaims.forEach(claim -> {
                    claim.setStatus(ClaimStatus.SUBMITTED);
                    claim.setVerificationStatus(VerificationStatus.NOT_VERIFIED);
                    List<LinkedDocument> docs = claim.getLinkedDocuments();
                    docs.forEach(doc -> {
                        doc.setClaim(claim);
                        doc.setType(LinkedDocType.INITIATED_BY_CLAIM_CREATING);
                    });
                });
                claimRepository.saveAll(financialClaims);
            } catch (Exception e) {
                errorCounter.increment();
            }
        });
    }
}
