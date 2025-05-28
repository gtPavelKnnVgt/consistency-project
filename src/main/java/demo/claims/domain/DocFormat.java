package demo.claims.domain;

import lombok.Getter;

/**
 * Формат Подтверждающего документа
 */
@Getter
public enum DocFormat {
    MANUAL("Бумажный"),
    DIGIT("Электронный");

    private final String description;

    DocFormat(String description) {
        this.description = description;
    }
}
