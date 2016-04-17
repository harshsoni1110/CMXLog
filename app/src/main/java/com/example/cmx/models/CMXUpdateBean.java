package com.example.cmx.models;

import java.util.Date;

/**
 * Created by HaRsH on 05-04-2016.
 */
public class CMXUpdateBean {


    private String projectName;
    private Date timeAndDate;
    private String projectId;
    private String subject;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getTimeAndDate() {
        return timeAndDate;
    }

    public void setTimeAndDate(Date timeAndDate) {
        this.timeAndDate = timeAndDate;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
