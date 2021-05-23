//package model;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class MatchStatsTest {
//    MatchStats testStats1;
//    MatchStats testStats2;
//    MatchStats testStats3;
//    MatchStats testStats4;
//    MatchStats testStats5;
//    MatchStats testStats6;
//    MatchStats testStats7;
//
//    @BeforeEach
//    void runBefore() {
//        testStats1 = new MatchStats("7-5 6-1", 10, 1, 4, 7);
//        testStats2 = new MatchStats("7-5 6-1", 10, 1, 4, 7);
//        testStats3 = new MatchStats("7-5 6-2", 10, 1, 4, 7);
//        testStats4 = new MatchStats("7-5 6-1", 11, 1, 4, 7);
//        testStats5 = new MatchStats("7-5 6-1", 10, 2, 4, 7);
//        testStats6 = new MatchStats("7-5 6-1", 10, 1, 5, 7);
//        testStats7 = new MatchStats("7-5 6-1", 10, 1, 4, 8);
//    }
//
//    @Test
//    void testConstructor() {
//        assertEquals("7-5 6-1", testStats1.getScore());
//        assertEquals(10, testStats1.getAces());
//        assertEquals(1, testStats1.getDoubleFaults());
//        assertEquals(4, testStats1.getWinners());
//        assertEquals(7, testStats1.getUnforcedErrors());
//    }
//
//    @Test
//    void testEqualsIsEqual() {
//        boolean isEqual = testStats1.equals(testStats2);
//
//        assertTrue(isEqual);
//    }
//
//    @Test
//    void testEqualsIsNotEqual() {
//        boolean isEqual1 = testStats1.equals(testStats3);
//        assertFalse(isEqual1);
//
//        boolean isEqual2 = testStats1.equals(testStats4);
//        assertFalse(isEqual2);
//
//        boolean isEqual3 = testStats1.equals(testStats5);
//        assertFalse(isEqual3);
//
//        boolean isEqual4 = testStats1.equals(testStats6);
//        assertFalse(isEqual4);
//
//        boolean isEqual5 = testStats1.equals(testStats7);
//        assertFalse(isEqual5);
//    }
//
//    @Test
//    void testEqualsNotAnInstanceOf() {
//        boolean isEqual = testStats1.equals("random string");
//
//        assertFalse(isEqual);
//    }
//
//    @Test
//    void testEqualsSameObject() {
//        MatchStats testStats4 = testStats3;
//
//        boolean isEqual = testStats3.equals(testStats4);
//
//        assertTrue(isEqual);
//    }
//
//    @Test
//    void testHashCodesAreEqual() {
//        int statsCode1 = testStats1.hashCode();
//        int statsCode2 = testStats2.hashCode();
//
//        assertEquals(statsCode1, statsCode2);
//    }
//
//    @Test
//    void testHashCodesAreNotEqual() {
//        int statsCode1 = testStats1.hashCode();
//        int statsCode3 = testStats3.hashCode();
//
//        assertNotEquals(statsCode1, statsCode3);
//    }
//}
