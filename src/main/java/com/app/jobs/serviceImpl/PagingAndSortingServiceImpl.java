package com.app.jobs.serviceImpl;

import com.app.jobs.entity.JobPosting;
import com.app.jobs.repository.JobPostingRepository;
import com.app.jobs.service.PagingAndSortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PagingAndSortingServiceImpl implements PagingAndSortingService {

    @Autowired
    private JobPostingRepository repository;

    @Override
    public Page<JobPosting> getJobs(int page, int size, String sortBy) {
        return repository.findAll(PageRequest.of(page, size, Sort.by(sortBy)));
    }
}
