package com.uum._a2;

import static com.uum._a2.Keyword.map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aman
 */
public class KeywordTest {
    
    public KeywordTest() {
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
     * Test of addKeywords method, of class Keyword.
     */
    @Test
    public void testAddKeywords() {
        System.out.println("addKeywords");
        Keyword.addKeywords();
        assertNotNull(map);
    }
    
}
