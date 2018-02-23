package org.mrhu.smartlab.service;

import org.mrhu.smartlab.model.Report;

public interface ReportService {
    void save(Report report);
    Report get(Report exampleReport);
    void delete(Report report);
    Report update(Report report);
}
