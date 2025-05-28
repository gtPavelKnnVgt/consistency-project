package demo.claims.adapter.persistence;

import demo.claims.app.api.impl.RepaymentDemandRepository;
import demo.claims.domain.RepaymentDemandLink;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RepaymentDemandRepositoryImpl implements RepaymentDemandRepository {
    private final RepaymentDemandJpaRepository repaymentDemandJpaRepository;

    @Override
    public void saveAll(List<RepaymentDemandLink> links) {
        repaymentDemandJpaRepository.saveAll(links);
    }
}
