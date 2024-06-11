package com.example.managementSystem.Service;

import com.example.managementSystem.Dtos.TaskDto;
import com.example.managementSystem.Entity.Task;
import com.example.managementSystem.Exception.NoUserExists;
import com.example.managementSystem.Repository.TaskRepo;
import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class TaskService {
    TaskRepo taskRepo;
    public TaskService(TaskRepo taskRepo) {
     this.taskRepo = taskRepo;
    }

    public Task createTask(TaskDto taskdto) {
       Task task=new Task();
       task.setTitle(taskdto.title());
       task.setTaskStatus(taskdto.taskStatus());
       task.setStartTime(taskdto.startTime());
       task.setEndTime(taskdto.endTime());
        return taskRepo.save(task);

    }

    public Task findTaskById(int id) {
        Task task = taskRepo.findById(id).orElseThrow(
                () -> new NoUserExists("Task", "ID", id)
        );
        return task;
    }

    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }
    public Task updateTask(int id,TaskDto taskdto) {
        Task existingTask = taskRepo.findById(id).orElseThrow(
                () -> new NoUserExists("Task", "ID", id)
        );

            existingTask.setTitle(taskdto.title());
            existingTask.setTaskStatus(taskdto.taskStatus());
            existingTask.setStartTime(taskdto.startTime());
            existingTask.setEndTime(taskdto.endTime());
            return taskRepo.save(existingTask);


    }
    public String deleteTaskById(int id) {
       taskRepo.deleteById(id);
        return "Task deleted";
    }

    public List<Task>SortByid(){
        List<Task> tasks = taskRepo.SortByid();
        return tasks;
    }

}
