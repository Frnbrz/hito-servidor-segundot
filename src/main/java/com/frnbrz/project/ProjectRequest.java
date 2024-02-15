package com.frnbrz.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProjectRequest {

    private Integer id;
    private String title;
    private String description;
}
