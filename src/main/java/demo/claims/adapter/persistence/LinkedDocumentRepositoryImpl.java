package demo.claims.adapter.persistence;

import demo.claims.app.api.LinkedDocumentRepository;
import demo.claims.domain.LinkedDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LinkedDocumentRepositoryImpl implements LinkedDocumentRepository {
    private final LinkedDocumentJpaRepository jpaRepository;
    @Override
    public void saveAll(List<LinkedDocument> linkedDocuments) {
        jpaRepository.saveAll(linkedDocuments);
    }
}
