package demo.claims.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Требование о возврате финансирования
 */
@Entity
@Table(name = "repayment_demand_link")
@Getter
@Setter
public class RepaymentDemandLink extends BusinessObject {
    @Column(name = "number", nullable = false)
    private String number;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private RepaymentDemandType type;
    @Column(name = "amount", nullable = false)
    private BigDecimal amount = BigDecimal.ZERO;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "financial_claim_id")
    private FinancialClaim financialClaim;
}
