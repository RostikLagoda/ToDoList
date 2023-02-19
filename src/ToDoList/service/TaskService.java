package ToDoList.service;

import ToDoList.entity.Task;

import java.util.List;

public interface TaskService {

    Task getByName(String name);
    void save(Task task);
    List<Task> getAll();
    void update(int id, Task task);
    void removeById(int id);
}
