package org.mrhu.smartlab.dto;

public class ProjectMemberDutyDto {
    private String name;
    private String grade;
    private String startTime;
    private String contact;
    private String duty;

    public String getName() {
        return name;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public void setName(String name) {
        this.name = name;

    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
