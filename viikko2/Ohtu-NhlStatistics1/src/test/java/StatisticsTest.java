/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import ohtuesimerkki.PlayerReader;
import ohtuesimerkki.Reader;
import ohtuesimerkki.Statistics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel Viktor Isaac
 */
public class StatisticsTest {
    
    Statistics stats;
    Reader reader;
    
    public StatisticsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws FileNotFoundException {
        this.reader = new PlayerReader();
        this.stats = new Statistics(reader);
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void testTest(){
        this.stats = new Statistics();
        assertEquals(10,10);
    }
    @Test
    public void teamListaOnOikeanMittainen(){
        
        assertEquals(this.stats.team("BOS").size(),20);
    }
    @Test
    public void topListaOnOikeanMittainen(){
        
        assertEquals(this.stats.topScorers(6).size(),7);
    }
    @Test
    public void searchPalauttaaPelaajan(){
        try{
        assertTrue(this.stats.search("Spezza").getName().length() > 0);
        }catch(Exception e){
            assertTrue(false);
        }
    }
    @Test
    public void searchFailTuottaaNull(){
        assertNull(this.stats.search("Kustaa Aadolf"));
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
