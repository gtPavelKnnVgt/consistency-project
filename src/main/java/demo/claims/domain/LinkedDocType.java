package demo.claims.domain;

/**
 * Тип подтверждающего документа
 */
public enum LinkedDocType {
    /**
     * Документ, подтверждающий возникновение ДТ
     */
    INITIATED_BY_CLAIM_CREATING,
    /**
     * Документ, подтверждающий изменение ДТ
     */
    INITIATED_BY_CLAIM_ALTERING
}
