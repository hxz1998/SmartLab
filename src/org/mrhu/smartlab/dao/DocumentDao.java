package org.mrhu.smartlab.dao;

import org.mrhu.smartlab.model.Document;

public interface DocumentDao {

    void save(Document document);
    Document load(Document exampleDocument);
    void delete(Document document);
    Document update(Document document);
}
