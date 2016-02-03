/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st20048261;

import java.util.Date;

/**
 *This class refers to object Tweet to store the data from the JSON file
 * @author paulobalbino
 */
public class Tweet {

    private String id;
    private Date date;
    private String message;
    private Coordinates coordinate;
    private double sentiRating = 0;
    private int area = 0;

    public Tweet(String id, Date date, String message, Coordinates coordinate) {
        this.id = id;
        this.date = date;
        this.message = message;
        this.coordinate = coordinate;
    }

    /**
     * This method sets the Area for each using the biggest and smaller coordinates
     * @param xB
     * @param xS
     * @param yB
     * @param yS 
     */
    public void setArea(double xB, double xS, double yB, double yS) {
            if(coordinate.getX() <= xS + ((xB - xS)/3)){
                if(coordinate.getY() <= yS + ((yB - yS)/3))
                    area = 1;
                else if(coordinate.getY() <= yS + (2*((yB - yS)/3)))
                    area = 2;
                else
                    area = 3;
            }else if(coordinate.getX() <= xS + (2* ((xB - xS)/3))){
                if(coordinate.getY() <= yS + ((yB - yS)/3))
                    area = 4;
                else if(coordinate.getY() <= yS+(2* ((yB - yS)/3)))
                    area = 5;
                else
                    area = 6;
            }else{
                if(coordinate.getY() <= yS + ((yB - yS)/3))
                    area = 7;
                else if(coordinate.getY() <= yS +(2* ((yB - yS)/3)))
                    area = 8;
                else
                    area = 9;
            }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Coordinates getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinates coordinate) {
        this.coordinate = coordinate;
    }

    public double getSentiRating() {
        return sentiRating;
    }

    public void setSentiRating(double sentiRating) {
        this.sentiRating = sentiRating;
    }

    public int getArea() {
        return area;
    }

}
