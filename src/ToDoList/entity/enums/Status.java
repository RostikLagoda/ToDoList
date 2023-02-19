package ToDoList.entity.enums;

public enum Status {
    PLANNING("Планируется"),
    IN_PROGRESS("Выполняется"),
    FINISHED("Закончено");
    private String a;

    Status(String a) {
        this.a =a;
    }

    public String getName(){
        return a;
    }

    public static Status getStatusByText(String text) {
        if (PLANNING.getName().equals(text)) {
            return PLANNING;
        }
        if (IN_PROGRESS.getName().equals(text)) {
            return IN_PROGRESS;
        }
        if (FINISHED.getName().equals(text)) {
            return FINISHED;
        }
        System.out.printf("Status %s not found%n", text);
        return null;
    }
}
