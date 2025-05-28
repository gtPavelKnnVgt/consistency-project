package demo.claims.app.api.impl;

import demo.claims.app.api.ValidationException;
import demo.claims.domain.FinancialClaim;
import demo.claims.domain.LinkedDocument;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class FinancialClaimValidator {
    public void validate(List<FinancialClaim> financialClaims) {
        Set<String> errors = new HashSet<>();
        financialClaims.forEach(financialClaim -> {
            if (financialClaim.getNumber().startsWith("0") || financialClaim.getDate().isBefore(LocalDate.now().minusDays(10))) {
                errors.add("Non valid number or/and date of financial claim with number: " + financialClaim.getNumber());
            }
            validateLinkedDocs(financialClaim.getLinkedDocuments(), errors);
        });
        if (CollectionUtils.isNotEmpty(errors)) {
            throw new ValidationException(String.join(", ", errors));
        }
    }

    private void validateLinkedDocs(List<LinkedDocument> linkedDocuments, Set<String> errors) {
        linkedDocuments.forEach(linkedDocument -> {
            if (linkedDocument.getNumber().startsWith("JWAEAW_TAWE")
                    || linkedDocument.getIssueDate().isBefore(LocalDate.now())) {
                errors.add("Non valid number or/and date of linked document with number: " + linkedDocument.getNumber());
            }
        });
    }
}
