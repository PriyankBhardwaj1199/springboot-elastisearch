package com.app.jobs.controller;

import com.app.jobs.entity.JobPosting;
import com.app.jobs.service.CustomSearchService;
import com.app.jobs.service.JobPostingService;
import com.app.jobs.service.PagingAndSortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobsController {

    @Autowired
    private JobPostingService service;

    @Autowired
    private PagingAndSortingService pagingAndSortingService;

    @Autowired
    private CustomSearchService customSearchService;

    @PostMapping
    public JobPosting createJob(@RequestBody JobPosting job) {
        return service.saveJobPosting(job);
    }

    @PostMapping("/bulk")
    public List<JobPosting> createJobs(@RequestBody List<JobPosting> jobPostings) {
        return service.saveJobPostings(jobPostings);
    }

    @GetMapping("/searchByTitle")
    public List<JobPosting> searchJobs(@RequestParam String title) {
        return service.searchJobsByTitle(title);
    }

    @GetMapping("/filter")
    public List<JobPosting> filterJobs(@RequestParam String location) {
        return service.filterJobsByLocation(location);
    }

    @GetMapping("/paging")
    public Page<JobPosting> pagingAndSortingJobs(@RequestParam int page, @RequestParam int size, @RequestParam String sortBy) {
        return pagingAndSortingService.getJobs(page, size, sortBy);
    }

    @GetMapping("/search")
    public List<SearchHit<JobPosting>> searchByKeyword(@RequestParam String keyword) {
        return customSearchService.searchByCustomQuery(keyword).getSearchHits();
    }
}
