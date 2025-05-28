package demo.claims.app.api;

import demo.claims.domain.FinancialClaim;

import java.util.List;

public interface CreateMovementOutbound {
    void createMovements(List<FinancialClaim> claims);
}
