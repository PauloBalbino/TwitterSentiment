/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package twittersentiment;

import st20048261.Tweet;
import st20048261.Coordinates;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author paulobalbino
 */
public class TweetTest {
    
    public TweetTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setArea method, of class Tweet.
     */
    @Test
    public void testSetArea() {
        System.out.println("setArea");
        double xB = 10;
        double xS = 1;
        double yB = 10;
        double yS = 1;
        Tweet instance = new Tweet("@PauloBalbinooo", new Date(), "I don't know how to use JUnit properly", new Coordinates(4.0 , 4.0));
        instance.setArea(xB, xS, yB, yS);
        
        assertEquals(1, instance.getArea());
    }

    /**
     * Test of getId method, of class Tweet.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Tweet instance = new Tweet("@PauloBalbinooo", new Date(), "I don't know how to use JUnit properly", new Coordinates(4.0 , 4.0));
        String expResult = "@PauloBalbinooo";
        String result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Tweet.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "@PauloBalbinooo";
        Tweet instance = new Tweet(id, new Date(), "I don't know how to use JUnit properly", new Coordinates(4.0 , 4.0));
        instance.setId(id);
        assertEquals(id, instance.getId());
    }

    /**
     * Test of getDate method, of class Tweet.
     */
    @Test
    public void testGetDate() throws ParseException {
        System.out.println("getDate");
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        Tweet instance = new Tweet("@PauloBalbinooo", formatter.parse("01.01.0001"), "I don't know how to use JUnit properly", new Coordinates(4.0 , 4.0));
        Date expResult = formatter.parse("01.01.0001");
        Date result = instance.getDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDate method, of class Tweet.
     */
    @Test
    public void testSetDate() throws ParseException {
        System.out.println("setDate");
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        Date date = formatter.parse("01.01.0001");
        Tweet instance = new Tweet("@PauloBalbinooo", formatter.parse("01.01.0001"), "I don't know how to use JUnit properly", new Coordinates(4.0 , 4.0));
        instance.setDate(date);
        assertEquals(date, instance.getDate());
    }

    /**
     * Test of getMessage method, of class Tweet.
     */
    @Test
    public void testGetMessage() throws ParseException {
        System.out.println("getMessage");
        Tweet instance = new Tweet("@PauloBalbinooo", new Date(), "I don't know how to use JUnit properly", new Coordinates(4.0 , 4.0));
        String expResult = "I don't know how to use JUnit properly";
        String result = instance.getMessage();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMessage method, of class Tweet.
     */
    @Test
    public void testSetMessage() {
        System.out.println("setMessage");
        String message = "I don't know how to use JUnit properly";
        Tweet instance = new Tweet("@PauloBalbinooo", new Date(), null, new Coordinates(4.0 , 4.0));
        instance.setMessage(message);
        assertEquals(message, instance.getMessage());
    }

    /**
     * Test of getCoordinate method, of class Tweet.
     */
    @Test
    public void testGetCoordinate() {
        System.out.println("getCoordinate");
        Coordinates expResult = new Coordinates(4.0 , 4.0);
        Tweet instance = new Tweet("@PauloBalbinooo", new Date(), "I don't know how to use JUnit properly", new Coordinates(4.0 , 4.0));
        Coordinates result = instance.getCoordinate();
        assertEquals(expResult.getX(), result.getX(), 0.0);
        assertEquals(expResult.getY(), result.getY(), 0.0);
    }

    /**
     * Test of setCoordinate method, of class Tweet.
     */
    @Test
    public void testSetCoordinate() {
        System.out.println("setCoordinate");
        Coordinates coordinate = new Coordinates(4.0 , 4.0);
        Tweet instance = new Tweet("@PauloBalbinooo", new Date(), "I don't know how to use JUnit properly",new Coordinates(4.0 , 4.0));
        instance.setCoordinate(coordinate);
        assertEquals(coordinate.toString(), instance.getCoordinate().toString());
    }

    /**
     * Test of getSentiRating method, of class Tweet.
     */
    @Test
    public void testGetSentiRating() {
        System.out.println("getSentiRating");
        Tweet instance = new Tweet("@PauloBalbinooo", new Date(), "Hate", new Coordinates(4.0 , 4.0));
        instance.setSentiRating(-0.5);
        double expResult = -0.5;
        double result = instance.getSentiRating();
        assertEquals(expResult, result, -0.5);
    }

    /**
     * Test of setSentiRating method, of class Tweet.
     */
    @Test
    public void testSetSentiRating() {
        System.out.println("setSentiRating");
        double sentiRating = -0.5;
        Tweet instance = new Tweet("@PauloBalbinooo", new Date(), "Hate", new Coordinates(4.0 , 4.0));
        instance.setSentiRating(sentiRating);
        assertEquals(sentiRating, instance.getSentiRating(), 0.0);
    }

    /**
     * Test of getArea method, of class Tweet.
     */
    @Test
    public void testGetArea() {
        System.out.println("getArea");
        Tweet instance = new Tweet("@PauloBalbinooo", new Date(), "I don't know how to use JUnit properly", new Coordinates(4.0 , 4.0));
        int expResult = 1;
        instance.setArea(10, 1, 10, 1);
        int result = instance.getArea();
        assertEquals(expResult, result);
    }
    
}
