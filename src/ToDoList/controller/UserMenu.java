package ToDoList.controller;

import ToDoList.service.UserService;
import ToDoList.service.impl.UserServiceImpl;

import java.util.Scanner;

public class UserMenu {

    private final Scanner scan = new Scanner(System.in);
    private boolean flag = true;

    private UserService userService = new UserServiceImpl();
    private Menu menu = new Menu();

    public void start(){
        while(flag){
            System.out.println("1) Authorization.");
            System.out.println("2) Sign up.");
            System.out.println("3) Exit.");
            switch (scan.nextInt()) {
                case 1 -> authorization();
                case 2 -> signUp();
                case 3 -> flag = false;
            }
        }
    }

    private void authorization(){
        System.out.println("Enter email.");
        String email = scan.next();
        System.out.println("Enter password.");
        String password = scan.next();
        if(userService.existUserByEmailAndPassword(email,password)){
            menu.program();
        }

    }

    private void signUp(){
        System.out.println("Enter email.");
        String email = scan.next();
        System.out.println("Enter password.");
        String password = scan.next();
        System.out.println("Enter name.");
        String name = scan.next();
        userService.add(name, email, password);
    }
}
