package org.mrhu.smartlab.service;

import org.mrhu.smartlab.model.Project;

public interface ProjectService {
    void save(Project project);
    Project get(Project exampleProject);
    void delete(Project project);
    Project update(Project project);
}
