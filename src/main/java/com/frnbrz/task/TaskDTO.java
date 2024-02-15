package com.frnbrz.task;

import com.frnbrz.project.Project;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskDTO {

    private Integer id;
    private String title;
    private String description;
    private Project project;
    private Integer projectId;
}