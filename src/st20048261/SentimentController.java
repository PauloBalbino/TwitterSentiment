/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package st20048261;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.logging.log4j.LogManager;

/**
 *This class is part of the MVC design pattern, it controls the GUI and twitterSentiment
 * @author paulobalbino
 */
public final class SentimentController extends ControllerInterface{
    GUI gui;
    Methods methods;
    static org.apache.logging.log4j.Logger log = LogManager.getLogger(GUI.class.getName());
   
    
    /**
     * This constructor creates a GUI and call the functions of the GUI
     * @throws Exception 
     */
    public SentimentController() throws Exception {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        gui = new GUI();
        
        methods =  new Methods();
        super.manipulate();
        gui.pack();
        gui.setVisible(true);
    }
    
    /**
     * This method invokes the manipulator method of the GUI
     */
    @Override
    public void manipulator() {
        try {
            methods.manipulator(gui);
            log.debug("Table of tweets filled");
        } catch (Exception ex) {
            Logger.getLogger(SentimentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * This method invokes the mapManipulator method of the GUI
     */
    @Override
    public void mapManipulator() {
        try {
            methods.mapManipulator(gui);
            log.debug("Map generated and inserted into the GUI");
        } catch (IOException ex) {
            Logger.getLogger(SentimentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method invokes the chartManipulator method of the GUI
     */
    @Override
    public void chartManipulator() {
        methods.chartManipulator(gui);
        log.debug("Chart generated and inserted into the GUI");
    }
    
}
