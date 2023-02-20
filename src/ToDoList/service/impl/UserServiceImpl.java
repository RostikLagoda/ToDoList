package ToDoList.service.impl;

import ToDoList.entity.User;
import ToDoList.memory.MemoryUserService;
import ToDoList.memory.UserMemory;
import ToDoList.service.UserService;

public class UserServiceImpl implements UserService {

    MemoryUserService memoryUserService = new UserMemory();

    @Override
    public void add(String name, String email, String password) {
        User userDb = memoryUserService.getUserByEmail(email);

        if(userDb != null){
            System.out.println("This email is already taken.");
        } else {
            memoryUserService.add(new User(name, email, password));
            System.out.println("User created.");
        }
    }

    @Override
    public boolean existUserByEmailAndPassword(String email, String password){
        User userDb = memoryUserService.getUserByEmail(email);

        if(userDb == null){
            System.out.println("No such user exists.");
        } else{
            if(userDb.getPassword().equals(password)){
                System.out.println("You are logged in.");
                return true;
            }
        }
        return false;
    }
}
