package st20048261;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.*;

/**
 * This class manipulates the files and do most process of the system
 * @author paulobalbino
 */
public class TwitterSentiment {
    
    static Logger log = LogManager.getLogger(TwitterSentiment.class.getName());

    public static List<Tweet> list() throws IOException, Exception {
        //Get an Json Array from the Parser class
        Parser x = Parser.getInstance();
        JSONArray array = x.reader();

        //Create a list of Tweet to store the tweets from the JSon Array
        //Fill in the list with the tweets
        List<Tweet> tweetList = x.insertJsonIntoList(array);
        log.debug("tweetList is empty: " + tweetList.isEmpty());
        //Fill in the dictionary for SentiWordNet
        SWN3 SentiWord = new SWN3("SentiWordNet_3.0.0.txt");
        log.info("Loaded SentiWord file");

        //Find the higher and lower coordinates calling the method from the Coordinates Class
        Double[] aux = Coordinates.findHigherLowerCoordinates(tweetList);
        Double xmaior = aux[0];
        Double xmenor = aux[1];
        Double ymaior = aux[2];
        Double ymenor = aux[3];
        
        for (Tweet tweetList1 : tweetList) {
            String[] aux2 = (tweetList1.getMessage()).split(" ");
            double sent = 0;
            for (String aux21 : aux2) {
                try {
                    sent = sent + SentiWord.extract(aux21.replaceAll("([^a-zA-Z\\s])", "").toLowerCase());
                }catch (Exception ex) {
                    LogManager.getLogger(TwitterSentiment.class.getName());
                }
            }
            tweetList1.setSentiRating(sent);
            tweetList1.setArea(xmaior, xmenor, ymaior, ymenor); //Set area on the grid for each tweet
        }
        log.debug("Sentiment Rating Calculated");
        log.debug("Areas calculated");
        
        //Calculate general area sentiment
        for(int i=1; i<10; i++){
            double sentArea = 0;
            Iterator<Tweet> itr = tweetList.iterator();
            
            while(itr.hasNext()){
                Tweet aux3 = itr.next();
                if(aux3.getArea() == i)
                    sentArea = sentArea + aux3.getSentiRating();
            }
            
            System.out.println("Area: " + i + "   Sentiment Rating: " + sentArea);
        }
        log.debug("General Area Sentiment Calculated");
        return tweetList;
    }
}
