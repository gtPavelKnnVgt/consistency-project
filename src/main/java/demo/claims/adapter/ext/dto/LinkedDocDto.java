package demo.claims.adapter.ext.dto;

import demo.claims.domain.DocFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class LinkedDocDto {
    private String number;
    private LocalDate issueDate;
    private DocFormat format;
    private BigDecimal amount;
}
