package org.mrhu.smartlab.service;

import org.mrhu.smartlab.model.Honor;

public interface HonorService {

    void save(Honor honor);
    Honor get(Honor exampleHonor);
    void delete(Honor honor);
    Honor update(Honor honor);

}
