package demo.claims.adapter.ext.dto;

import demo.claims.domain.DocFormat;
import demo.claims.domain.LinkedDocType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class MovementLinkedDoc {
    private String number;
    private LocalDate issueDate;
    private DocFormat format;
    private LinkedDocType type;
    private BigDecimal amount;
}
