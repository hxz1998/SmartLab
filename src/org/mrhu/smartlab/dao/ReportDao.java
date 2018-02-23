package org.mrhu.smartlab.dao;

import org.mrhu.smartlab.model.Report;

public interface ReportDao {
    void save(Report report);
    Report load(Report exampleReport);
    void delete(Report report);
    Report update(Report report);
}
