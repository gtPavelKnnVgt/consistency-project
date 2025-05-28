package demo.claims.app.api.impl;

import demo.claims.domain.RepaymentDemandLink;

import java.util.List;

public interface RepaymentDemandRepository {
    void saveAll(List<RepaymentDemandLink> links);
}
