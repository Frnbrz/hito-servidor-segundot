package com.frnbrz.project;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectDTO {

    private Integer id;
    private String title;
    private String description;
    private Project project;
    private Integer projectId;
}