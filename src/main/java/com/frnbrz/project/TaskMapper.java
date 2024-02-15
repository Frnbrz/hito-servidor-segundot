package com.frnbrz.project;


import com.frnbrz.task.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public Task taskDtoToTask(ProjectDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setId(taskDTO.getId());
        task.setProjectId(taskDTO.getProjectId());

        return task;
    }

    public ProjectDTO taskToLlamadaDto (Task task) {
        if (task == null) {
            return null;
        }
        ProjectDTO.TaskDTOBuilder taskDTO = ProjectDTO.builder();
        taskDTO.id(task.getId());
        taskDTO.title(task.getTitle());
        taskDTO.description(task.getDescription());
        taskDTO.projectId(task.getProjectId());



        return taskDTO.build();
    }


}
