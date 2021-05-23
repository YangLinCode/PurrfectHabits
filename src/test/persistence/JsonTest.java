//package persistence;
//
//import model.MatchDetails;
//import model.MatchStats;
//import model.TennisMatch;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//// Note: The structure of this class and the method inside it is based on
////       the WorkRoom application given to us on GitHub.
////       URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
//public class JsonTest {
//    protected void checkMatch(MatchDetails details, MatchStats stats, TennisMatch match) {
//        MatchDetails md = match.getMatchDetails();
//        MatchStats ms = match.getMatchStats();
//
//        assertEquals(details.getOpponent(), md.getOpponent());
//        assertEquals(details.getIsWon(), md.getIsWon());
//        assertEquals(details.getSurface(), md.getSurface());
//        assertEquals(details.getDuration(), md.getDuration());
//        assertEquals(details.getDate(), md.getDate());
//
//        assertEquals(stats.getScore(), ms.getScore());
//        assertEquals(stats.getAces(), ms.getAces());
//        assertEquals(stats.getDoubleFaults(), ms.getDoubleFaults());
//        assertEquals(stats.getWinners(), ms.getWinners());
//        assertEquals(stats.getUnforcedErrors(), ms.getUnforcedErrors());
//    }
//}
