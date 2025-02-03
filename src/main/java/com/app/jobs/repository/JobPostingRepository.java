package com.app.jobs.repository;

import com.app.jobs.entity.JobPosting;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface JobPostingRepository extends ElasticsearchRepository<JobPosting,String> {

    List<JobPosting> findByTitle(String keyword);
    List<JobPosting> findByLocation(String location);
}
