package demo.claims.adapter.ext.dto;

import demo.claims.domain.ClaimStatus;
import demo.claims.domain.VerificationStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class MovementInfoDto {
    private BigDecimal amount;
    private String currency;
    private String number;
    private String date;
    private ClaimStatus status;
    private VerificationStatus verificationStatus;
    private List<MovementLinkedDoc> linkedDocuments;
}
