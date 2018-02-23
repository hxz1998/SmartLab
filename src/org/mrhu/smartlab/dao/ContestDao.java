package org.mrhu.smartlab.dao;

import org.mrhu.smartlab.model.Contest;

public interface ContestDao {
    void save(Contest contest);
    Contest load(Contest exampleContest);
    void delete(Contest contest);
    Contest update(Contest contest);
}
