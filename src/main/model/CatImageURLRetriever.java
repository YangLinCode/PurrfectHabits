package model;

//
public class CatImageURLRetriever {
    String catImageURL;

    public CatImageURLRetriever(Award.AwardType awardType) {
        if (awardType == Award.AwardType.PAWSOME_ACHIEVEMENT) {
            catImageURL = "https://cataas.com/cat/gif";
        } else if (awardType == Award.AwardType.FELINE_GOOD) {
            catImageURL = "https://cataas.com/cat";
        }
    }

    public String getCatImageURL() {
        return catImageURL;
    }
}
