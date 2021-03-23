package ru.netrax.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netrax.Model.Task;
import ru.netrax.Service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/list")
    public ResponseEntity<List<Task>> get() {
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/taskById")
    public ResponseEntity<Task> getById(@RequestParam("id") long id) {
        Task taskById = taskService.getTaskById(id);
        return new ResponseEntity<>(taskById, HttpStatus.OK);
    }

    @PutMapping("/updateTask")
    public ResponseEntity<?> updateTitle(@RequestBody Task task) {
        boolean result = taskService.updateTask(task.getId(), task.getName(), task.getDescription());
        return result ?
                new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("/deleteTask")
    public ResponseEntity<?> deleteById(@RequestParam("id") long id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/addTask")
    public ResponseEntity<?> addTask(@RequestParam("name") String name,
                                     @RequestParam("description") String description
    ) {
        try {
            taskService.insertTask(name, description);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
