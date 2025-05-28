package demo.claims.domain;

import java.time.LocalDate;

public record PatientDetails(String fio, String address, LocalDate birth, String userExtId) {
}
