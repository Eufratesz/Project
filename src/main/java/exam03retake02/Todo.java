package exam03retake02;

public class Todo {

    private String text;
    private State state = State.NON_COMPLETED;
    private int priority;

    public Todo(String text, int priority) {
        if (priority > 5 || priority < 1) {
            throw new IllegalArgumentException("Invalid" + priority);
        }
        this.text = text;
        this.priority = priority;

    }


    public String getText() {
        return text;
    }

    public State getState() {
        return state;
    }

    public int getPriority() {
        return priority;
    }

    public void complete() {
        state = State.COMPLETED;
    }

}

