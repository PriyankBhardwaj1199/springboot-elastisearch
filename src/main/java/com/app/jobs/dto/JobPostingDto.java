package com.app.jobs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingDto {

    public String title;
    public String description;
    public String company;
    public String location;
    public List<String> skills;
    public double salary;
    public String jobType;
}
