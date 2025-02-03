package com.app.jobs.serviceImpl;

import com.app.jobs.entity.JobPosting;
import com.app.jobs.service.CustomSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomSearchServiceImpl implements CustomSearchService {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Override
    public SearchHits<JobPosting> searchByCustomQuery(String keyword) {
        // Use NativeQuery.builder() to define the multi-match query
        NativeQuery query = NativeQuery.builder()
                .withQuery(q -> q.multiMatch(m -> m
                        .query(keyword)
                        .fields(List.of("title", "description", "skills")) // Specify the fields for the multi-match
                ))
                .build();

        // Execute the query
        return elasticsearchOperations.search(query, JobPosting.class);
    }
}
