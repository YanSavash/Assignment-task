package ru.netrax.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netrax.Model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
