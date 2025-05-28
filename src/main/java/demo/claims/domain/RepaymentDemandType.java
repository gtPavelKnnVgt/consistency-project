package demo.claims.domain;

import lombok.Getter;

/**
 * Тип требования о возврате финансирования
 */
@Getter
public enum RepaymentDemandType {
    RECOURSE("В связи с наступление регресса"),
    SELF_REFUND("Добровольный возврат"),
    INVALIDATED("Недействительная сумма Денежного требования");

    private final String description;

    RepaymentDemandType(String description) {
        this.description = description;
    }
}
