package org.mrhu.smartlab.dao;

import org.mrhu.smartlab.model.Project;
import org.mrhu.smartlab.model.ProjectMemberDuty;
import org.mrhu.smartlab.model.User;

import java.util.Map;

public interface ProjectMemberDao {

    Map<User, ProjectMemberDuty> getAllMemberAndDuty(Project project);
}
