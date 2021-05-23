package model.exceptions;

public class HabitAlreadyExistsException extends Exception {
    public HabitAlreadyExistsException() {
        super("This habit already exists");
    }
}
