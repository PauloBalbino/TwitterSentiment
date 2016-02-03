/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st20048261;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;

/**
 *This class parse the JSON file
 * @author paulobalbino
 */
public class Parser {
    private static Parser uniqueInstance;
    
    private Parser(){
    }
    
    public static Parser getInstance(){
        if(uniqueInstance == null)
            uniqueInstance = new Parser();
        return new Parser();
    }
    
    /**
     * This method parse the json file into an array and returns it into the method on which is called
     * @return 
     */
    public JSONArray reader() {
        try {
            String file = new String(Files.readAllBytes(Paths.get("dummy_tweet.json")));
            JSONObject obj = new JSONObject(file);
            JSONArray arr = obj.getJSONArray("tweets");
            return arr;
        } catch (IOException ex) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * This method returns a List of Tweets and manipulate the date to a DateFormat and returns it
     * @param array
     * @return
     * @throws ParseException 
     */
    public List<Tweet> insertJsonIntoList(JSONArray array) throws ParseException{
        List<Tweet> tweetList = new ArrayList<>();        
        //Read the Json Object into an auxiliar tweet, that will be stored into a list of tweets by the end of it
        for (int i = 0; i < array.length(); i++) {
            Tweet aux = new Tweet(null, null, null, null);
            aux.setId(array.getJSONObject(i).get("id").toString());

            DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            aux.setDate(formatter.parse(array.getJSONObject(i).get("date-time").toString()));
            aux.setMessage(array.getJSONObject(i).get("message").toString());
            
            JSONArray coordinates = array.getJSONObject(i).getJSONArray("coordinates");
            double coordX = coordinates.getDouble(0);
            double coordY = coordinates.getDouble(1);
            
            aux.setCoordinate(new Coordinates(coordX, coordY));
            tweetList.add(aux);
        }
        return tweetList;
    }
}
