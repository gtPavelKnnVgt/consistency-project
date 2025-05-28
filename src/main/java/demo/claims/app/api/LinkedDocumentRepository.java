package demo.claims.app.api;

import demo.claims.domain.LinkedDocument;

import java.util.List;

public interface LinkedDocumentRepository {
    void saveAll(List<LinkedDocument> linkedDocuments);
}
