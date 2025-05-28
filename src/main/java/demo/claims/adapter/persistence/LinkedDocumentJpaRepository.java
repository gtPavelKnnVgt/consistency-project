package demo.claims.adapter.persistence;

import demo.claims.domain.LinkedDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkedDocumentJpaRepository extends JpaRepository<LinkedDocument, Long> {
}
