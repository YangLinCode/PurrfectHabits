package model;

import javafx.scene.image.Image;
import java.time.LocalDate;

public class Award {
    public enum AwardType {
        FELINE_GOOD, PAWSOME_ACHIEVEMENT
    }

    LocalDate dateReceived; // as long as you know the award's date, you can retrieve it from the database
    AwardType awardType;

    public Award(LocalDate dateReceived, AwardType awardType) {
        this.dateReceived = dateReceived;
        this.awardType = awardType;
    }

    public LocalDate getDateReceived() {
        return dateReceived;
    }

    public AwardType getAwardType() {
        return awardType;
    }
}

