package ru.netrax.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.netrax.Model.Task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DisplayName("Проверка класса TaskServiceImpl")
@Import({TaskServiceImpl.class})
public class TaskServiceTest {

    @Autowired
    TaskService taskService;

    private Task rightTask;
    private Task wrongTask;

    @BeforeEach
    void prepare() {
        this.rightTask = new Task(1,"Первая задача","Первое описание");
        this.wrongTask = new Task(4, "Четвертая задача", "Четвёртое описание");
    }

    @DisplayName("проверка получения списка книг")
    @Test
    void checkList() {
        assertThat(taskService.getAllTasks())
                .hasSize(3)
                .doesNotContain(wrongTask);
    }

    @DisplayName("проверка добавления книг")
    @Test
    void checkInsertBook() {
        taskService.insertTask(wrongTask.getName(), wrongTask.getDescription());
        List<Task> allBooks = taskService.getAllTasks();
        assertThat(allBooks.contains(wrongTask));
    }

    @DisplayName("проверка получения книг по id")
    @Test
    void checkById() {
        assertThat(taskService.getTaskById(1).toString())
                .isEqualTo(rightTask.toString());
    }

    @DisplayName("проверка удаления книг")
    @Test
    void checkDeleteAuthor() {
        taskService.deleteTask(1L);
        assertThat(taskService.getAllTasks()).doesNotContain(rightTask);
    }
}
