package ru.netrax.Service;

import ru.netrax.Model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();

    Task insertTask(String name, String description);

    Task getTaskById(long id);

    boolean updateTask(long id, String name, String description);

    void deleteTask(long id);
}
