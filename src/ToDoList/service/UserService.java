package ToDoList.service;

public interface UserService {

    void add(String name, String email, String password);
    boolean existUserByEmailAndPassword(String email, String password);
}
