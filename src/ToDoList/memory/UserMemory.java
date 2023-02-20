package ToDoList.memory;

import ToDoList.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserMemory implements MemoryUserService {

    private final List<User> users = new ArrayList<>();

    private long id = 1;

    @Override
    public void add(User user){
        user.setId(id);
        id++;
        users.add(user);
    }

    @Override
    public User getUserByEmail(String email){
        return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst().orElse(null);
    }

}
