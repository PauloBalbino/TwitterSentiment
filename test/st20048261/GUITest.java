/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package st20048261;

import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 *
 * @author paulobalbino
 */
public class GUITest {
    
    public GUITest() {
        try {
            GUI gui = new GUI();
        } catch (Exception ex) {
            Logger.getLogger(GUITest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Test if first tab can be selected
     * @throws Exception 
     */
    @Test
    public void testTab0() throws Exception{
        GUI gui = new GUI();
        gui.setVisible(true);
        gui.getjTabbedPane1().setSelectedIndex(0);
        assertEquals(gui.getjTabbedPane1().getSelectedIndex(), 0);
    }
    
    /**
     * Test if second tab can be selected
     * @throws Exception 
     */
    @Test
    public void testTab1() throws Exception{
        GUI gui = new GUI();
        gui.setVisible(true);
        gui.getjTabbedPane1().setSelectedIndex(1);
        assertEquals(gui.getjTabbedPane1().getSelectedIndex(), 1);
    }
    
    /**
     * Test if third tab can be selected
     * @throws Exception 
     */
    @Test
    public void testTab2() throws Exception{
        GUI gui = new GUI();
        gui.setVisible(true);
        gui.getjTabbedPane1().setSelectedIndex(2);
        assertEquals(gui.getjTabbedPane1().getSelectedIndex(), 2);
    }
    
    
}
