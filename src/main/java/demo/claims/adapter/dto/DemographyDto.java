package demo.claims.adapter.dto;

import java.time.LocalDate;

public record DemographyDto(String fio, String address, LocalDate birth, String userExtId) {
}
