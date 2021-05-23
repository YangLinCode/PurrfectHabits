//package model;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class MatchDetailsTest {
//    private MatchDetails testDetails1;
//    private MatchDetails testDetails2;
//    private MatchDetails testDetails3;
//    private MatchDetails testDetails4;
//    private MatchDetails testDetails5;
//    private MatchDetails testDetails6;
//    private MatchDetails testDetails7;
//
//    @BeforeEach
//    void runBefore() {
//        testDetails1 = new MatchDetails("Yang Lin", false, "HARD", 45, "1/1/2020");
//        testDetails2 = new MatchDetails("Yang Lin", false, "HARD", 45, "1/1/2020");
//        testDetails3 = new MatchDetails("Roger Federer", false, "HARD", 45, "1/1/2020");
//        testDetails4 = new MatchDetails("Yang Lin", true, "HARD", 45, "1/1/2020");
//        testDetails5 = new MatchDetails("Yang Lin", false, "GRASS", 45, "1/1/2020");
//        testDetails6 = new MatchDetails("Yang Lin", false, "HARD", 55, "1/1/2020");
//        testDetails7 = new MatchDetails("Yang Lin", false, "HARD", 45, "1/2/2020");
//    }
//
//
//    @Test
//    void testConstructor() {
//        assertEquals("Yang Lin", testDetails1.getOpponent());
//        assertFalse(testDetails1.getIsWon());
//        assertEquals("HARD", testDetails1.getSurface());
//        assertEquals(45, testDetails1.getDuration());
//        assertEquals("1/1/2020", testDetails1.getDate());
//    }
//
//    @Test
//    void testEqualsIsEqual() {
//        boolean isEqual = testDetails1.equals(testDetails2);
//
//        assertTrue(isEqual);
//    }
//
//    @Test
//    void testEqualsIsNotEqual() {
//        boolean isEqual1 = testDetails1.equals(testDetails3);
//        assertFalse(isEqual1);
//
//        boolean isEqual2 = testDetails1.equals(testDetails4);
//        assertFalse(isEqual2);
//
//        boolean isEqual3 = testDetails1.equals(testDetails5);
//        assertFalse(isEqual3);
//
//        boolean isEqual4 = testDetails1.equals(testDetails6);
//        assertFalse(isEqual4);
//
//        boolean isEqual5 = testDetails1.equals(testDetails7);
//        assertFalse(isEqual5);
//    }
//
//    @Test
//    void testEqualsNotAnInstanceOf() {
//        boolean isEqual = testDetails1.equals("random string");
//
//        assertFalse(isEqual);
//    }
//
//    @Test
//    void testEqualsSameObject() {
//        MatchDetails testDetails4 = testDetails3;
//
//        boolean isEqual = testDetails3.equals(testDetails4);
//
//        assertTrue(isEqual);
//    }
//
//    @Test
//    void testHashCodesAreEqual() {
//        int detailsCode1 = testDetails1.hashCode();
//        int detailsCode2 = testDetails2.hashCode();
//
//        assertEquals(detailsCode1, detailsCode2);
//    }
//
//    @Test
//    void testHashCodesAreNotEqual() {
//        int detailsCode1 = testDetails1.hashCode();
//        int detailsCode3 = testDetails3.hashCode();
//
//        assertNotEquals(detailsCode1, detailsCode3);
//    }
//}
