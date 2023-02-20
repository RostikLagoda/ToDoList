package ToDoList.memory;

import ToDoList.entity.User;

public interface MemoryUserService {

        void add(User user);
        User getUserByEmail(String email);
}
