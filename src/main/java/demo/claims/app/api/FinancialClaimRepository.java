package demo.claims.app.api;

import demo.claims.domain.FinancialClaim;

import java.util.List;

public interface FinancialClaimRepository {
    void save(FinancialClaim financialClaim);

    void saveAll(List<FinancialClaim> financialClaims);
}
