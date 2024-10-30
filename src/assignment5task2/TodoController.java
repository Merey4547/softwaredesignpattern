package assignment5task2;

import java.util.ArrayList;
import java.util.List;

public class TodoController {
    private final List<Todo> todos = new ArrayList<>();

    public List<Todo> getTodos() {
        return todos;
    }

    public void addTodo(String title) {
        todos.add(new Todo(title));
    }

    public void deleteTodo(int index) {
        if (index >= 0 && index < todos.size()) {
            todos.remove(index);
        }
    }
}
