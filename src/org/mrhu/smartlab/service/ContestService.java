package org.mrhu.smartlab.service;

import org.mrhu.smartlab.model.Contest;

public interface ContestService {
    void save(Contest contest);
    Contest get(Contest exampleContest);
    void delete(Contest contest);
    Contest update(Contest contest);
}
