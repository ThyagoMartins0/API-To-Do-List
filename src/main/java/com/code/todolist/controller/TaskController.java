package com.code.todolist.controller;


import com.code.todolist.service.TaskService;
import com.code.todolist.model.Task;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController// this is a controller class
@RequestMapping("/api/v1")// base url
@AllArgsConstructor// lombok annotation for constructor
@Slf4j// lombok annotation for logger
public class TaskController {

    TaskService taskService;


    @PostMapping("/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task)// @RequestBody annotation is used to bind the request body with a method parameter.
    { log.info("Task created[{}]",task);
        return taskService.createTask(task);
    }

    @GetMapping("/tasks")
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getAllTasks() {
        return taskService.listAllTasks();
    }

    @GetMapping("/tasks/{id}")// {id} is a path variable
    @ResponseStatus(HttpStatus.OK)// this annotation is used to set the http status code
    public ResponseEntity<Task> getTaskById(@PathVariable (value = "id") Long id)// @PathVariable annotation is used to bind the path variable with a method parameter.
     { log.info("Task found[{}]",id);
        return taskService.findTaskById(id);
    }


    @PutMapping  ("/tasks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> UpdateById(@PathVariable (value = "id")Long id, @RequestBody Task task)
    {log.info("Task updated[{}]",id);
        return taskService.updateTaskId(task,id);
    }
    @DeleteMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> DeleteById(@PathVariable (value = "id") Long id)
    {log.info("Task deleted[{}]",id);
        return taskService.deleteById(id);
    }


}
