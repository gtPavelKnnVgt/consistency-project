package demo.claims.app.api;

import demo.claims.domain.FinancialClaim;

import java.util.List;

public interface CreateFinancialClaimInbound {
    /**
     * Создать ДТ
     * @param financialClaim ДТ, которое будет создано
     */
    void create(FinancialClaim financialClaim);
    /**
     * Создать Пачку ДТ
     * @param financialClaims Пачка ДТ, которая будет создана
     */
    void createBatch(List<FinancialClaim> financialClaims);
}
