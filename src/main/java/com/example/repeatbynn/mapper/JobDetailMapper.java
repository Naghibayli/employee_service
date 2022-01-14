package com.example.repeatbynn.mapper;

import com.example.repeatbynn.dto.request.JobDetailRequest;
import com.example.repeatbynn.dto.response.JobDetailResponse;
import com.example.repeatbynn.entity.JobDetail;
import org.springframework.stereotype.Component;

@Component
public class JobDetailMapper {

    public JobDetail toEntity(JobDetailRequest request) {
        JobDetail jobDetail = new JobDetail();
        jobDetail.setStartDate(request.getStartDate());
        jobDetail.setEndDate(request.getEndDate());
        jobDetail.setPresent(request.isPresent());
        jobDetail.setSalary(request.getSalary());
        return jobDetail;
    }

    public JobDetailResponse toResponse(JobDetail jobDetail) {
        JobDetailResponse jobDetailResponse = new JobDetailResponse();
        jobDetailResponse.setId(jobDetail.getId());
        jobDetailResponse.setCreatedAt(jobDetail.getCreatedAt());
        jobDetailResponse.setStartDate(jobDetail.getStartDate());
        jobDetailResponse.setEndDate(jobDetail.getEndDate());
        jobDetailResponse.setPresent(jobDetail.isPresent());
        jobDetailResponse.setSalary(jobDetail.getSalary());
        return jobDetailResponse;
    }
}
