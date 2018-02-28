package org.mrhu.smartlab.dao;

import org.mrhu.smartlab.model.Project;
import org.mrhu.smartlab.model.ProjectMemberDuty;

public interface ProjectMemberDutyDao {

    String getAllMemberAndDutyToJson(Project project);
    void save(ProjectMemberDuty projectMemberDuty);

}
