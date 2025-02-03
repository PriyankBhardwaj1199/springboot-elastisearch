package com.app.jobs.serviceImpl;

import com.app.jobs.entity.JobPosting;
import com.app.jobs.repository.JobPostingRepository;
import com.app.jobs.service.JobPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostingServiceImpl implements JobPostingService {

    @Autowired
    private JobPostingRepository repository;

    @Override
    public JobPosting saveJobPosting(JobPosting job) {
        return repository.save(job);
    }

    @Override
    public List<JobPosting> saveJobPostings(List<JobPosting> jobPostings) {
        return (List<JobPosting>) repository.saveAll(jobPostings);
    }

    @Override
    public List<JobPosting> searchJobsByTitle(String title) {
        return repository.findByTitle(title);
    }

    @Override
    public List<JobPosting> filterJobsByLocation(String location) {
        return repository.findByLocation(location);
    }
}
