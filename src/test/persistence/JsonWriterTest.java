//package persistence;
//
//import model.MatchDetails;
//import model.MatchStats;
//import model.TennisMatch;
//import model.TennisMatchJournal;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.io.IOException;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.fail;
//
//// NOTE: The structure of this class and many of the methods in it are based off of
////       the JsonWriterTest class in the WorkRoom application that was given to us
////       on GitHub.
////       URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
//public class JsonWriterTest extends JsonTest {
//    MatchDetails matchDetails1;
//    MatchStats matchStats1;
//    MatchDetails matchDetails2;
//    MatchStats matchStats2;
//    MatchDetails matchDetails3;
//    MatchStats matchStats3;
//    TennisMatch tennisMatch1;
//    TennisMatch tennisMatch2;
//    TennisMatch tennisMatch3;
//
//    @BeforeEach
//    void runBefore() {
//        matchDetails1 = new MatchDetails("Yang Lin", false, "hard", 30, "10/25/2020");
//        matchStats1 = new MatchStats("0-6 0-6", 0, 10, 0, 10);
//        tennisMatch1 = new TennisMatch(matchDetails1, matchStats1);
//
//        matchDetails2 = new MatchDetails("Rafael Nadal", true, "clay", 120, "10/25/2020");
//        matchStats2 = new MatchStats("6-4 6-4", 6, 2, 12, 9);
//        tennisMatch2 = new TennisMatch(matchDetails2, matchStats2);
//
//        matchDetails3 = new MatchDetails("Roger Federer", true, "grass", 60, "10/25/2020");
//        matchStats3 = new MatchStats("7-6 7-6", 4, 1, 15, 4);
//        tennisMatch3 = new TennisMatch(matchDetails3, matchStats3);
//    }
//
//    @Test
//    void testWriterInvalidFile() {
//        try {
//            TennisMatchJournal journal = new TennisMatchJournal();
//            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
//            writer.open();
//            fail("IOException was expected"); // we are expecting to throw an IOException
//        } catch (IOException e) {
//            // our test passes
//        }
//    }
//
//    @Test
//    void testWriterEmptyWorkroom() {
//        try {
//            TennisMatchJournal journal = new TennisMatchJournal();
//            JsonWriter writer = new JsonWriter("./data/testWriterEmptyJournal.json");
//            writer.open();
//            writer.write(journal);
//            writer.close();
//
//            JsonReader reader = new JsonReader("./data/testWriterEmptyJournal.json");
//            journal = reader.read();
//            assertEquals(0, journal.journalLength());
//        } catch (IOException e) {
//            fail("Exception should not have been thrown"); // we are not expecting an IOException to be thrown
//        }
//    }
//
//    @Test
//    void testWriterGeneralJournal() {
//        try {
//            TennisMatchJournal journal = new TennisMatchJournal();
//            journal.addMatch(tennisMatch1);
//            journal.addMatch(tennisMatch2);
//            journal.addMatch(tennisMatch3);
//
//            JsonWriter writer = new JsonWriter("./data/testWriterGeneralJournal.json");
//            writer.open();
//            writer.write(journal);
//            writer.close();
//
//            JsonReader reader = new JsonReader("./data/testWriterGeneralJournal.json");
//            journal = reader.read();
//            List<TennisMatch> matches = journal.getJournal();
//
//            assertEquals(3, matches.size());
//            checkMatch(matchDetails1, matchStats1, matches.get(0));
//            checkMatch(matchDetails2, matchStats2, matches.get(1));
//            checkMatch(matchDetails3, matchStats3, matches.get(2));
//        } catch (IOException e) {
//            fail("Exception should not have been thrown"); // we are not expecting to get an IOException
//        }
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
