package model;

import model.exceptions.HabitAlreadyExistsException;

import java.util.ArrayList;
import java.util.List;

import static model.Habit.HabitType.BREAKABLE;
import static model.Habit.HabitType.MAKEABLE;

// represents a dashboard where the user can look at all their current habits
public class Dashboard {
    private List<Habit> habitsToBreak;
    private List<Habit> habitsToMake;
    private List<Habit> allHabits;

    public Dashboard() {
        habitsToBreak = new ArrayList<Habit>();
        habitsToMake = new ArrayList<Habit>();
        allHabits = new ArrayList<Habit>();
    }

    public List<Habit> getHabitsToBreak() {
        return habitsToBreak;
    }

    public List<Habit> getHabitsToMake() {
        return habitsToMake;
    }

    public List<Habit> getAllHabits() {
        return allHabits;
    }

    // add new habit to proper habits list, then add it to allHabits
    public void addHabitJson(Habit habit) {
        if (habit.getHabitType() == MAKEABLE && !habitsToMake.contains(habit)) {
            habitsToMake.add(habit);
        } else if (habit.getHabitType() == BREAKABLE && !habitsToBreak.contains(habit)) {
            habitsToBreak.add(habit);
        }

        if (!allHabits.contains(habit)) {
            allHabits.add(habit);
        }
    }

    public void addHabit(Habit habit) throws HabitAlreadyExistsException {
        if (habit.getHabitType() == MAKEABLE && !habitsToMake.contains(habit)) {
            habitsToMake.add(habit);
        } else if (habit.getHabitType() == BREAKABLE && !habitsToBreak.contains(habit)) {
            habitsToBreak.add(habit);
        }

        if (!allHabits.contains(habit)) {
            allHabits.add(habit);
        }

        // TODO: un-hardcode this
        String destination = "C:\\Users\\ylynn\\OneDrive\\Documents\\Coding Projects\\PurrfectHabits\\data\\habits";
        FolderManager folderManager = new FolderManager(destination);
        folderManager.createHabitDirectory(habit.getTitle());
    }

    // remove habit from proper habits list, then remove it from allHabits
    // TODO: make this throw an exception
    public void removeHabit(Habit habit) {
        if (habit.getHabitType() == MAKEABLE) {
            habitsToMake.remove(habit);
        } else {
            habitsToBreak.remove(habit);
        }

        allHabits.remove(habit);

        String destination = "C:\\Users\\ylynn\\OneDrive\\Documents\\Coding Projects\\PurrfectHabits\\data\\habits";
        FolderManager folderManager = new FolderManager(destination);
        folderManager.deleteHabitDirectory(habit.getTitle());
    }
}
