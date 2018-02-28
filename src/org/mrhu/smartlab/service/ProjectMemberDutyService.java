package org.mrhu.smartlab.service;

import org.mrhu.smartlab.model.Project;
import org.mrhu.smartlab.model.ProjectMemberDuty;

public interface ProjectMemberDutyService {

    void save(ProjectMemberDuty projectMemberDuty);
    String getAllDetailToJson(Project project);

}
