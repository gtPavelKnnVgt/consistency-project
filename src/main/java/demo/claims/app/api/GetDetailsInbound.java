package demo.claims.app.api;

import demo.claims.domain.PatientDetails;

public interface GetDetailsInbound {
    /**
     * Получить информацию о пациенте
     *
     * @param userId внешний ID пациента
     * @return информация
     */
    PatientDetails getDetails(String userId);
}
