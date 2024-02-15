package com.frnbrz.project;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectRequest {

    private Integer id;
    private String title;
    private String description;
}
