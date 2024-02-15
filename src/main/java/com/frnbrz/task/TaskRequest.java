package com.frnbrz.task;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequest {

    private Integer id;
    private String title;
    private String description;
}
