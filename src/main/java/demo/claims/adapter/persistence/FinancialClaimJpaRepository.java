package demo.claims.adapter.persistence;

import demo.claims.domain.FinancialClaim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialClaimJpaRepository extends JpaRepository<FinancialClaim, Long> {
}
