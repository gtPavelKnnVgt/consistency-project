package demo.claims.adapter.ext.dto;

import demo.claims.domain.FinancialClaim;
import demo.claims.domain.LinkedDocument;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovementDtoMapper {
    default CreateMovementsDto mapToDto(List<FinancialClaim> claims) {
        CreateMovementsDto target = new CreateMovementsDto();
        List<MovementInfoDto> movements = claims.stream().map(this::mapToDto).toList();
        target.setMovementsInfo(movements);
        return target;
    }

    MovementInfoDto mapToDto(FinancialClaim claim);

    MovementLinkedDoc mapToDto(LinkedDocument document);
}
