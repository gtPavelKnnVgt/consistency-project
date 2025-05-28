package demo.claims.domain;

import lombok.Getter;

/**
 * Статус верификации Денежного требования
 */
@Getter
public enum VerificationStatus {
    VERIFIED("Подтвержден"),
    NOT_VERIFIED("Не подтвержден"),
    AWAITING_VERIFICATION("В ожидании подтверждения"),
    SEND_TO_VERIFICATION_CENTER("Отправлен в подтверждающий центр");

    private final String description;

    VerificationStatus(String description) {
        this.description = description;
    }
}
