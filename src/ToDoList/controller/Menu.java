package ToDoList.controller;

import ToDoList.entity.Task;
import ToDoList.entity.enums.Status;
import ToDoList.service.TaskService;
import ToDoList.service.impl.TaskServiceImpl;

import java.util.Scanner;

public class Menu {
    private final Scanner scan =new Scanner(System.in);

    private TaskService taskService = new TaskServiceImpl();
    private boolean flag = true;

    public void start(){
        while(flag) {
            System.out.println("1) Create task.");
            System.out.println("2) Update task.");
            System.out.println("3) Remove task.");
            System.out.println("4) Get all.");
            int count = scan.nextInt();
            switch (count) {
                case 1 -> create();
                case 2 -> update();
                case 3 -> removeTaskById();
                case 4 -> getAll();
                case 5 -> flag=false;
            }
        }
    }

    private void create(){
        System.out.println("name");
        String name = scan.next();
        System.out.println("description");
        String description = scan.next();
        taskService.save(new Task(name,description));
        System.out.println("Success.");
    }

    private void update(){
        System.out.println("id");
        int id = scan.nextInt();
        System.out.println("name");
        String name = scan.next();
        System.out.println("description");
        String description = scan.next();
        System.out.println("status");
        String status1 = scan.next();
        Status.getStatusByText(status1);
        taskService.update(id,new Task(name,description,status1));

    }

    private void getAll(){
        System.out.println(taskService.getAll());
    }

    private void removeTaskById(){
        System.out.println("Id");
        int id = scan.nextInt();
        taskService.removeById(id);
    }
}
