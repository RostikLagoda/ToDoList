package ToDoList.service.impl;

import ToDoList.entity.Task;
import ToDoList.entity.enums.Status;
import ToDoList.memory.TaskMemory;
import ToDoList.service.TaskService;

import java.util.List;

public class TaskServiceImpl implements TaskService {

    private TaskMemory taskMemory = new TaskMemory();

    @Override
    public Task getByName(String name) {
        return taskMemory.getByName(name);
    }

    @Override
    public void save(Task task) {
        task.setStatus(Status.PLANNING);
        taskMemory.add(task);
    }

    @Override
    public List<Task> getAll() {
        return taskMemory.getAll();
    }

    @Override
    public void update(int id, Task task) {
        taskMemory.update(task,id);
    }

    @Override
    public void removeById(int id) {
        taskMemory.removeById(id);
    }
}
