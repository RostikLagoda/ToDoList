package ToDoList.memory;

import ToDoList.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskMemory {

   private List<Task> tasks = new ArrayList<>();
   private int i=1;

   public void add(Task task){
       task.setId(i);
       tasks.add(task);
       i++;
   }

   public List<Task> getAll(){
       return tasks;
   }

   public Task getByName(String name){
      return tasks.stream()
               .filter(task -> name.equals(task.getName()))
               .findFirst().orElse(null);
   }

   public void update(Task task, int id){
       for (int i = 0; i <tasks.size() ; i++) {
           if (tasks.get(i).getId()==id) {
               task.setId(id);
               tasks.set(i,task);
               break;
           }
       }
   }

   public void removeById(int id){
       int task1 = tasks.stream()
               .filter(i -> i.getId()==id)
               .mapToInt(i -> i.getId())
               .findFirst().orElse(0);
       tasks.remove(task1);
   }
}
