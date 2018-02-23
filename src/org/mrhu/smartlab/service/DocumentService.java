package org.mrhu.smartlab.service;

import org.mrhu.smartlab.model.Document;

public interface DocumentService {

    void save(Document document);
    Document get(Document exampleDocument);
    void delete(Document document);
    Document update(Document document);
}
