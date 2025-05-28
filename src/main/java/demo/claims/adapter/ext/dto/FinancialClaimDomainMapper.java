package demo.claims.adapter.ext.dto;

import demo.claims.domain.FinancialClaim;
import demo.claims.domain.LinkedDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FinancialClaimDomainMapper {

    default List<FinancialClaim> mapToDomain(List<ClaimsInfoDto> source) {
        return source.stream().map(this::mapToDomain).toList();
    }

    @Mapping(target = "linkedDocuments", source = "linkedDocs")
    FinancialClaim mapToDomain(ClaimsInfoDto source);

    LinkedDocument mapToDomain(LinkedDocDto docSource);
}
