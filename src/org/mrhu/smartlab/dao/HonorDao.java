package org.mrhu.smartlab.dao;

import org.mrhu.smartlab.model.Honor;

public interface HonorDao {

    void save(Honor honor);
    Honor load(Honor exampleHonor);
    void delete(Honor honor);
    Honor update(Honor honor);

}
