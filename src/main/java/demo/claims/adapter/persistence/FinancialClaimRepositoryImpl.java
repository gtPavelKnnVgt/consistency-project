package demo.claims.adapter.persistence;

import demo.claims.app.api.FinancialClaimRepository;
import demo.claims.domain.FinancialClaim;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FinancialClaimRepositoryImpl implements FinancialClaimRepository {
    private final FinancialClaimJpaRepository jpaRepository;

    @Override
    public void save(FinancialClaim financialClaim) {
        jpaRepository.save(financialClaim);
    }

    @Override
    public void saveAll(List<FinancialClaim> financialClaims) {
        jpaRepository.saveAll(financialClaims);
    }
}
