package com.app.jobs.service;

import com.app.jobs.entity.JobPosting;

import java.util.List;

public interface JobPostingService {
    JobPosting saveJobPosting(JobPosting job);

    List<JobPosting> saveJobPostings(List<JobPosting> jobPostings);

    List<JobPosting> searchJobsByTitle(String title);

    List<JobPosting> filterJobsByLocation(String location);
}
