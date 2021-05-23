package model;

import java.time.LocalDate;

public class Stats {
    private int currentStreak;
    private int longestStreak;
    private LocalDate dateCreated;
    private int numDaysSinceStarted;
    private int numSetbacks;

    public Stats(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
        currentStreak = 0;
        longestStreak = 0;
        numDaysSinceStarted = 0;
        numSetbacks = 0;
    }

    public Stats(int currentStreak, int longestStreak, LocalDate dateCreated, int numDaysSinceStarted, int numSetbacks) {
        this.currentStreak = currentStreak;
        this.longestStreak = longestStreak;
        this.dateCreated = dateCreated;
        this.numDaysSinceStarted = numDaysSinceStarted;
        this.numSetbacks = numSetbacks;
    }

    public int getCurrentStreak() {
        return currentStreak;
    }

    public int getLongestStreak() {
        return longestStreak;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public int getNumDaysSinceStarted() {
        return numDaysSinceStarted;
    }

    public int getNumSetbacks() {
        return numSetbacks;
    }

    private void incrementCurrentStreak() {
        currentStreak++;
    }

    private void resetCurrentStreak() {
        currentStreak = 0;
    }

    private void incrementLongestStreak() {
        longestStreak++;
    }

    private void updateNumDaysSinceStarted() {
        numDaysSinceStarted++;
    }

    private void updateNumSetbacks() {
        numSetbacks++;
    }

}
