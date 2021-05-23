package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.time.LocalDate;
import java.util.List;

public class Habit implements Writable {
    public enum HabitType {
        MAKEABLE, BREAKABLE
    }

    private String title;
    private String purpose;
    private boolean isCompleted;
    private Stats habitStats;
    private HabitType habitType;
    private Gallery awardsGallery;

    public Habit(String title, String purpose, HabitType habitType) {
        this.title = title;
        this.purpose = purpose;
        this.habitType = habitType;
        isCompleted = false;
        LocalDate date = LocalDate.now();
        habitStats = new Stats(date);
        awardsGallery = new Gallery();
    }

    public Habit(String title, String purpose, boolean isCompleted, Stats habitStats, HabitType habitType, Gallery awardsGallery) {
        this.title = title;
        this.purpose = purpose;
        this.isCompleted = isCompleted;
        this.habitStats = habitStats;
        this.habitType = habitType;
        this.awardsGallery = awardsGallery;
    }

    public Habit(String title) {
        this.title = title;
        purpose = null;
        isCompleted = false;
        habitStats = null;
        habitType = null;
        awardsGallery = null;
    }

    public String getTitle() {
        return title;
    }

    public String getPurpose() {
        return purpose;
    }

    public boolean getCompletionStatus() {
        return isCompleted;
    }

    public Stats getHabitStats() {
        return habitStats;
    }

    public HabitType getHabitType() {
        return habitType;
    }

    public Gallery getAwardsGallery() {
        return awardsGallery;
    }

    @Override
    public JSONObject toJson() {
        JSONObject mainObject = new JSONObject();
        mainObject.put("title", title);
        mainObject.put("purpose", purpose);
        mainObject.put("isCompleted", isCompleted);
        JSONObject statsObject = new JSONObject();
        statsObject.put("currentStreak", habitStats.getCurrentStreak());
        statsObject.put("longestStreak", habitStats.getLongestStreak());
        statsObject.put("dateCreated", habitStats.getDateCreated().toString());
        statsObject.put("numDaysSinceStarted", habitStats.getNumDaysSinceStarted());
        statsObject.put("numSetbacks", habitStats.getNumSetbacks());
        mainObject.put("habitStats", statsObject);
        mainObject.put("habitType", habitType.toString());
        JSONObject galleryObject = new JSONObject();
        JSONArray felineGoodArray = new JSONArray();
        JSONArray pawsomeAchievementArray = new JSONArray();
        JSONArray allAwardsArray = new JSONArray();
        JSONArray bestStreakArray = new JSONArray();
        List<Award> feline = awardsGallery.getFelineGoodAwards();
        List<Award> pawsome = awardsGallery.getPawsomeAchievementAwards();
        List<Award> all = awardsGallery.getAllAwards();
        List<Award> best = awardsGallery.getBestStreakAwards();
        for (Award award : feline) {
            JSONObject obj = new JSONObject();
            obj.put("dateReceived", award.getDateReceived());
            obj.put("awardType", award.getAwardType());
            felineGoodArray.put(obj);
        }
        for (Award award : pawsome) {
            JSONObject obj = new JSONObject();
            obj.put("dateReceived", award.getDateReceived());
            obj.put("awardType", award.getAwardType());
            pawsomeAchievementArray.put(obj);
        }
        for (Award award : all) {
            JSONObject obj = new JSONObject();
            obj.put("dateReceived", award.getDateReceived());
            obj.put("awardType", award.getAwardType());
            allAwardsArray.put(obj);
        }
        for (Award award : best) {
            JSONObject obj = new JSONObject();
            obj.put("dateReceived", award.getDateReceived());
            obj.put("awardType", award.getAwardType());
            bestStreakArray.put(obj);
        }
        galleryObject.put("felineGoodAwards", felineGoodArray);
        galleryObject.put("pawsomeAchievementAwards", pawsomeAchievementArray);
        galleryObject.put("allAwards", allAwardsArray);
        galleryObject.put("bestStreakAwards", bestStreakArray);
        mainObject.put("awardsGallery", galleryObject);
        return mainObject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Habit habit = (Habit) o;

        return title != null ? title.equals(habit.title) : habit.title == null;
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }
}


