package demo.claims.domain;

import lombok.Getter;

/**
 * Статусы Денежного требования
 */
@Getter
public enum ClaimStatus {
    SUBMITTED("Отправлено"),
    SUSPENDED("Приостановлено"),
    PAID("Оплачено"),
    PARTIALLY_PAID("Частично оплачено"),
    DECLINED("Отказано"),
    FUNDED("Финансировано"),
    CLOSED("Закрыто"),
    OVERDUE("Просрочено");

    private final String description;

    ClaimStatus(String description) {
        this.description = description;
    }
}
