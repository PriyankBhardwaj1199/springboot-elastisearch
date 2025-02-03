package com.app.jobs.service;

import com.app.jobs.entity.JobPosting;
import org.springframework.data.elasticsearch.core.SearchHits;

public interface CustomSearchService {
    SearchHits<JobPosting> searchByCustomQuery(String keyword);
}
