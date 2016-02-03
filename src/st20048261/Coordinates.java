
package st20048261;

import java.util.List;

/**
 * This class manipulates the coordinates of the JSON file
 * @author Paulo Campos st20048261
 */
public class Coordinates {
    private double x;
    private double y;
    
    public Coordinates(Double x, Double y){
        this.x = x;
        this.y = y;
    }

    public Coordinates() {
    }
    
    /**
     * Find the higher and lower coordinates and return an Array of Double
     * @param tweetList
     * @return 
     */
    public static Double[] findHigherLowerCoordinates(List<Tweet> tweetList){
        Double xmaior = 0.0, xmenor = 0.0, ymaior = 0.0, ymenor = 0.0;
        
        for (int j = 0; j < tweetList.size(); j++) {
            if(j == 0){
                xmaior = tweetList.get(j).getCoordinate().getX();
                xmenor = tweetList.get(j).getCoordinate().getX();
                ymaior = tweetList.get(j).getCoordinate().getY();
                ymenor = tweetList.get(j).getCoordinate().getY();
            }else{
                if (tweetList.get(j).getCoordinate().getX() > xmaior)
                    xmaior = tweetList.get(j).getCoordinate().getX();
                if (tweetList.get(j).getCoordinate().getX() < xmenor)
                    xmenor = tweetList.get(j).getCoordinate().getX();
                if (tweetList.get(j).getCoordinate().getY() > ymaior)
                    ymaior = tweetList.get(j).getCoordinate().getY();
                if (tweetList.get(j).getCoordinate().getY() < ymenor)
                    ymenor = tweetList.get(j).getCoordinate().getY();
            }
        }
        return new Double[]{xmaior, xmenor, ymaior, ymenor};
    }
    
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }
    
}
