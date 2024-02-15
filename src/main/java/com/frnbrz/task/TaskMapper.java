package com.frnbrz.task;


import com.frnbrz.project.Project;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public Task taskDtoToTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setId(taskDTO.getId());
        task.setProjectId(taskDTO.getProjectId());

        return task;
    }

    public TaskDTO taskToLlamadaDto (Task task) {
        if (task == null) {
            return null;
        }
        TaskDTO.TaskDTOBuilder taskDTO = TaskDTO.builder();
        taskDTO.id(task.getId());
        taskDTO.title(task.getTitle());
        taskDTO.description(task.getDescription());
        taskDTO.projectId(task.getProjectId());



        return taskDTO.build();
    }


}
