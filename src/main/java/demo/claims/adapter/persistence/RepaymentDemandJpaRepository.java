package demo.claims.adapter.persistence;

import demo.claims.domain.RepaymentDemandLink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepaymentDemandJpaRepository extends JpaRepository<RepaymentDemandLink, Long> {
}
