package demo.claims.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "financial_claim")
@Getter
@Setter
public class FinancialClaim extends BusinessObject {
    @Column(name = "number", nullable = false)
    private String number;
    @Column(name = "date", nullable = false)
    private LocalDate date;
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ClaimStatus status;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "agreement_id")
    private Agreement agreement;
    @Column(name = "verification_status")
    @Enumerated(EnumType.STRING)
    private VerificationStatus verificationStatus;
    @OneToMany(mappedBy = "claim", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<LinkedDocument> linkedDocuments;
    @OneToMany(mappedBy = "financialClaim", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RepaymentDemandLink> repaymentDemandLinks;
}
