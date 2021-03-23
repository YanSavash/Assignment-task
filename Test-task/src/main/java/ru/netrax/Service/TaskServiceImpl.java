package ru.netrax.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netrax.Model.Task;
import ru.netrax.Repository.TaskRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task insertTask(String name, String description) {
        Task task = new Task();
        task.setName(name);
        task.setDescription(description);
        task.setLastModificationDate(new Date());
        return taskRepository.save(task);
    }

    @Override
    public Task getTaskById(long id) {
        return taskRepository.findById(id).orElseThrow();
    }

    @Override
    public boolean updateTask(long id, String name, String description) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setName(name);
        task.setDescription(description);
        task.setLastModificationDate(new Date());
        try {
            taskRepository.save(task);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public void deleteTask(long id) {
        taskRepository.deleteById(id);
    }
}
