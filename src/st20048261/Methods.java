/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package st20048261;

import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *This class contains the methods necessary to manipulate the software
 * @author paulobalbino
 */
public class Methods {
    private final List<Tweet> tweetList;
    
    
    public Methods() throws Exception{
        tweetList = TwitterSentiment.list();
    }
    
     public void manipulator(GUI gui) throws Exception{
        String col[] = {"(ID","Coordinates","Date", "Sentiment Rating", "Area", "Message"};

        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        gui.getTableTweets().setModel(tableModel);
        
        for(Tweet tweetList1 : tweetList){
            String id = tweetList1.getId();
            String date = tweetList1.getDate().toString();
            String message = tweetList1.getMessage();
            String coordinates = tweetList1.getCoordinate().toString();
            double sentiRating = tweetList1.getSentiRating();
            int area =tweetList1.getArea();
            
            Object[] tweet = {id, coordinates, date, sentiRating, area, message};
            tableModel.addRow(tweet);
        }
    }
     
     public void mapManipulator(GUI gui) throws MalformedURLException, IOException{
        String html = "https://maps.googleapis.com/maps/api/staticmap?size=640x640&scale=1";
        int count1, count2, count3, count4, count5, count6, count7, count8, count9;
        count1 = count2 = count3 = count4 = count5 = count6 = count7 = count8 = count9 = 0;
        
        for(Tweet tweetList1 : tweetList){
            if(tweetList1.getArea() == 1){
                html = html.concat("&markers=color:black%7Clabel:" + count1 + "%7C" + tweetList1.getCoordinate().toString() + "%7C");
                count1++;
            }else if (tweetList1.getArea() == 2){
                html = html.concat("&markers=color:brown%7Clabel:" + count2 + "%7C" + tweetList1.getCoordinate().toString() + "%7C");
                count2++;
            }else if (tweetList1.getArea() == 3){
                html = html.concat("&markers=color:green%7Clabel:" + count3 + "%7C" + tweetList1.getCoordinate().toString() + "%7C");
                count3++;
            }else if (tweetList1.getArea() == 4){
                html = html.concat("&markers=color:purple%7Clabel:" + count4 + "%7C" + tweetList1.getCoordinate().toString() + "%7C");
                count4++;
            }else if (tweetList1.getArea() == 5){
                html = html.concat("&markers=color:yellow%7Clabel:" + count5 + "%7C" + tweetList1.getCoordinate().toString() + "%7C");
                count5++;
            }else if (tweetList1.getArea() == 6){
                html = html.concat("&markers=color:blue%7Clabel:" + count6 + "%7C" + tweetList1.getCoordinate().toString() + "%7C");
                count6++;
            }else if (tweetList1.getArea() == 7){
                html = html.concat("&markers=color:gray%7Clabel:" + count7 + "%7C" + tweetList1.getCoordinate().toString() + "%7C");
                count7++;
            }else if (tweetList1.getArea() == 8){
                html = html.concat("&markers=color:orange%7Clabel:" + count8 + "%7C" + tweetList1.getCoordinate().toString() + "%7C");
                count8++;
            }else if (tweetList1.getArea() == 9){
                html = html.concat("&markers=color:red%7Clabel:" + count9 + "%7C" + tweetList1.getCoordinate().toString() + "%7C");
                count9++;
            }
        }
        System.out.print(html);
        
        Image mapImage;
        URL url = new URL(html);
        mapImage = ImageIO.read(url);
        Runner.log.debug("Image URL downloaded");
        ImageIcon mapImageIcon = new ImageIcon(mapImage);
        JLabel picLabel = new JLabel();
        gui.getMapLabel().setIcon(mapImageIcon);
    }
     
     public void chartManipulator(GUI gui){
        JFreeChart barChart = ChartFactory.createBarChart("Sentiment Tweets", "ID", "Rating", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        
        ImageIcon chartImageIcon = new ImageIcon(barChart.createBufferedImage(1024  , 768));
        
        //ChartPanel chartPanel = new ChartPanel(barChart);
        //chartPanel.setPreferredSize(new java.awt.Dimension(640, 640));
        gui.getChartLabel().setIcon(chartImageIcon);
        //jPanel1 = new ChartPanel(barChart);
        //Container contentPane = new ChartPanel(barChart);
        //chartLabel.add(barChart);
        //jPanel1.setVisible(true);
        
    }
     
    public CategoryDataset createDataset(){
        final String area1 = "Area 1";
        final String area2 = "Area 2";
        final String area3 = "Area 3";
        final String area4 = "Area 4";
        final String area5 = "Area 5";
        final String area6 = "Area 6";
        final String area7 = "Area 7";
        final String area8 = "Area 8";
        final String area9 = "Area 9";
        
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for(Tweet tweetList1 : tweetList){
            switch(tweetList1.getArea()){
                case 1:
                    dataset.addValue(tweetList1.getSentiRating(), tweetList1.getId(), area1);
                    break;
                case 2:
                    dataset.addValue(tweetList1.getSentiRating(), tweetList1.getId(), area2 );
                    break;
                case 3:
                    dataset.addValue(tweetList1.getSentiRating(),tweetList1.getId(), area3);
                    break;
                case 4:
                    dataset.addValue(tweetList1.getSentiRating(), tweetList1.getId(), area4 );
                    break;
                case 5:
                    dataset.addValue(tweetList1.getSentiRating(), tweetList1.getId(), area5 );
                    break;
                case 6:
                    dataset.addValue(tweetList1.getSentiRating(), tweetList1.getId(), area6 );
                    break;
                case 7:
                    dataset.addValue(tweetList1.getSentiRating(), tweetList1.getId(), area7 );
                    break;
                case 8:
                    dataset.addValue(tweetList1.getSentiRating(), tweetList1.getId(), area8 );
                    break;
                case 9:
                    dataset.addValue(tweetList1.getSentiRating(), tweetList1.getId(), area9 );
                    break;
            } 
        }
        return dataset;
    }


}

