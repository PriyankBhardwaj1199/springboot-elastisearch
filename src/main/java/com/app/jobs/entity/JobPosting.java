package com.app.jobs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@Document(indexName = "job_postings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPosting {

    @Id
    private String id;
    private String title;
    private String description;
    private String company;
    private String location;
    private List<String> skills;
    private double salary;
    private String jobType;
}
