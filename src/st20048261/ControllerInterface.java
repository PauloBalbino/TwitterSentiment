/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package st20048261;

import org.jfree.data.category.CategoryDataset;

/**
 *It in interface so that SentimentController implements
 * @author paulobalbino
 */
public abstract class ControllerInterface {
    abstract void manipulator();
    abstract void mapManipulator();
    abstract void chartManipulator();
    
    public void manipulate(){
        manipulator();
        mapManipulator();
        chartManipulator();
    }

}
