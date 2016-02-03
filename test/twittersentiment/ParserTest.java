/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package twittersentiment;

import st20048261.Parser;
import org.json.JSONArray;
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
public class ParserTest {
    
    public ParserTest() {
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
     * Test of reader method, of class Parser.
     */
    @Test
    public void testReader() {
        System.out.println("reader");
        Parser instance = Parser.getInstance();
        JSONArray expResult = instance.reader();
        JSONArray result = instance.reader();
        assertEquals(expResult.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.

    }
    
}
