package demo.claims.adapter.ext.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ClaimsInfoDto {
    private String number;
    private LocalDate date;
    private List<LinkedDocDto> linkedDocs;
}
