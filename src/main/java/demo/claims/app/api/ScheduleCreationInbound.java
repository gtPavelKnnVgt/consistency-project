package demo.claims.app.api;

import demo.claims.domain.FinancialClaim;

import java.util.List;

public interface ScheduleCreationInbound {
    /**
     * Запланировать выполнения в отдельной задаче
     * @param financialClaims
     */
    void schedule(List<FinancialClaim> financialClaims);
}
