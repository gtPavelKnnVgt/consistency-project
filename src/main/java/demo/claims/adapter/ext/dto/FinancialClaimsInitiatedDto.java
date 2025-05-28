package demo.claims.adapter.ext.dto;

import lombok.Data;

import java.util.List;

@Data
public class FinancialClaimsInitiatedDto {
    private List<ClaimsInfoDto> claimsInfo;
}
