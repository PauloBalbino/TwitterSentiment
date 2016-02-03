/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package st20048261;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Starts the system
 * @author paulobalbino
 */
public class Runner {
    static Logger log = LogManager.getLogger(Runner.class.getName());
    
    public static void main(String[] args) throws Exception{
        log.debug("SYSTEM INTIALIZED");
        SentimentController controler = new SentimentController();
        log.debug("SYSTEM CLOSED");
    }
}
