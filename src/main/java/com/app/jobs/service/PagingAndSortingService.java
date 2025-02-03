package com.app.jobs.service;

import com.app.jobs.entity.JobPosting;
import org.springframework.data.domain.Page;

public interface PagingAndSortingService {
    Page<JobPosting> getJobs(int page, int size, String sortBy);
}
