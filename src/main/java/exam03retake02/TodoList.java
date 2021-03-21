package exam03retake02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TodoList {

    List<Todo>todoList = new ArrayList<>();


    public List<Todo> getTodos() {
        return new ArrayList<>(todoList);
    }

    public void addTodo(Todo todo) {
        todoList.add(todo);
    }


    public int getNumberOfItemsLeft() {
        int count = 0;
        for(Todo todo : todoList){
            if(todo.getState().equals(State.NON_COMPLETED)){
                count++;
            }
        }

        return count;
    }


    public List<String> getMostImportantTodosText() {
        List<String>mostImportantText = new ArrayList<>();
        int min = 5;
        for(Todo todo : todoList){
            if(todo.getPriority()< min){
                min=todo.getPriority();
                mostImportantText.clear();
                mostImportantText.add(todo.getText());
            }
            else if(min == todo.getPriority()){
                mostImportantText.add(todo.getText());
            }
        }
        return mostImportantText;
    }

    public void deleteCompleted() {
       List<Todo>toDelete = new ArrayList<>();
       for (Todo todo: todoList){
           if(todo.getState() == State.COMPLETED){
               toDelete.add(todo);

           }
        }
       todoList.removeAll(toDelete);
    }
}
