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
////       the JsonReaderTest class in the WorkRoom application that was given to us
////       on GitHub.
////       URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
//public class JsonReaderTest extends JsonTest {
//    MatchDetails matchDetails1;
//    MatchStats matchStats1;
//    MatchDetails matchDetails2;
//    MatchStats matchStats2;
//    MatchDetails matchDetails3;
//    MatchStats matchStats3;
//
//    @BeforeEach
//    void runBefore() {
//        matchDetails1 = new MatchDetails("Yang Lin", false, "hard", 30, "10/25/2020");
//        matchStats1 = new MatchStats("0-6 0-6", 0, 10, 0, 10);
//
//        matchDetails2 = new MatchDetails("Rafael Nadal", true, "clay", 120, "10/25/2020");
//        matchStats2 = new MatchStats("6-4 6-4", 6, 2, 12, 9);
//
//        matchDetails3 = new MatchDetails("Roger Federer", true, "grass", 60, "10/25/2020");
//        matchStats3 = new MatchStats("7-6 7-6", 4, 1, 15, 4);
//    }
//
//    @Test
//    void testReaderNonExistentFile() {
//        JsonReader reader = new JsonReader("./data/noSuchFile.json");
//
//        try {
//            TennisMatchJournal journal = reader.read();
//            fail("IOException expected"); // we are expecting read() to throw an IOException
//        } catch (IOException e) {
//            // our test passes
//        }
//    }
//
//    @Test
//    void testReaderEmptyJournal() {
//        JsonReader reader = new JsonReader("./data/testReaderEmptyJournal.json");
//
//        try {
//            TennisMatchJournal journal = reader.read();
//            assertEquals(0, journal.journalLength());
//        } catch (IOException e) {
//            fail("Couldn't read from file");
//        }
//    }
//
//    @Test
//    void testReaderGeneralJournal() {
//        JsonReader reader = new JsonReader("./data/testReaderGeneralJournal.json");
//
//        try {
//            TennisMatchJournal journal = reader.read();
//            List<TennisMatch> matches = journal.getJournal();
//
//            assertEquals(3, matches.size());
//            checkMatch(matchDetails1, matchStats1, matches.get(0));
//            checkMatch(matchDetails2, matchStats2, matches.get(1));
//            checkMatch(matchDetails3, matchStats3, matches.get(2));
//        } catch (IOException e) {
//            fail("Couldn't read from file");
//        }
//    }
//
//
//}
