package demo.claims.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Подтверждающие документы
 */
@Entity
@Table(name = "linked_document")
@Getter
@Setter
public class LinkedDocument extends BusinessObject {
    @Column(name = "number", nullable = false)
    private String number;
    @Column(name = "issue_date")
    private LocalDate issueDate;
    @Column(name = "format", nullable = false)
    @Enumerated(EnumType.STRING)
    private DocFormat format;
    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private LinkedDocType type;
    /**
     * Дата приемки
     */
    @Column(name = "close_date")
    private LocalDate closeDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "financial_claim_id", nullable = false)
    private FinancialClaim claim;
    @Column(name = "amount")
    private BigDecimal amount;
    /**
     * Информация о обработке сущности в личном кабинете пользователя
     */
    @Column(name = "personal_account_id")
    private String personalAccountId;
}
