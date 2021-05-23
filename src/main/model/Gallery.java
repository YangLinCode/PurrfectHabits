package model;

import java.util.ArrayList;
import java.util.List;

import static model.Award.AwardType.FELINE_GOOD;
import static model.Award.AwardType.PAWSOME_ACHIEVEMENT;

// represents a gallery where the user can look at all their awards
public class Gallery {
    private List<Award> felineGoodAwards;
    private List<Award> pawsomeAchievementAwards;
    private List<Award> allAwards;
    private List<Award> bestStreakAwards;

    public Gallery() {
        felineGoodAwards = new ArrayList<Award>();
        pawsomeAchievementAwards = new ArrayList<Award>();
        allAwards = new ArrayList<Award>();
        bestStreakAwards = new ArrayList<Award>();
    }

    public Gallery(List<Award> felineGoodAwards, List<Award> pawsomeAchievementAwards, List<Award> allAwards, List<Award> bestStreakAwards) {
        this.felineGoodAwards = felineGoodAwards;
        this.pawsomeAchievementAwards = pawsomeAchievementAwards;
        this.allAwards = allAwards;
        this.bestStreakAwards = bestStreakAwards;
    }

    public List<Award> getFelineGoodAwards() {
        return felineGoodAwards;
    }

    public List<Award> getPawsomeAchievementAwards() {
        return pawsomeAchievementAwards;
    }

    public List<Award> getAllAwards() {
        return allAwards;
    }

    public List<Award> getBestStreakAwards() {
        return bestStreakAwards;
    }

    public void addAward(Award award) {
        if (award.getAwardType() == FELINE_GOOD) {
            felineGoodAwards.add(award);
        } else if (award.getAwardType() == PAWSOME_ACHIEVEMENT) {
            pawsomeAchievementAwards.add(award);
        }

        allAwards.add(award);

        if (allAwards.size() >= bestStreakAwards.size()) {
            bestStreakAwards = allAwards;
        }
    }

    public void clearAwards() {
        felineGoodAwards.clear();
        pawsomeAchievementAwards.clear();
        allAwards.clear();
    }
}
