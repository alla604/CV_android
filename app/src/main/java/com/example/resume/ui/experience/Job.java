package com.example.resume.ui.experience;

public class Job {
    private String companyName;
    private String jobData;
    private String profession;
    private String description;
    private int mImageId;

    public Job (String companyName, String jobData, String profession, String description, int mImageId) {
        this.companyName = companyName;
        this.jobData = jobData;
        this.profession = profession;
        this.description = description;
        this.mImageId = mImageId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJobData() {
        return jobData;
    }

    public void setJobData(String jobData) {
        this.jobData = jobData;
    }

    public int getImageId() {
        return mImageId;
    }
}
