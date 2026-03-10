/**
 * Write a description of SecondRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;
    
    public SecondRatings() {
        myMovies = new ArrayList<Movie>();
        myRaters = new ArrayList<Rater>();
    }
    
    public SecondRatings(String moviefile, String ratingsfile){
        FirstRatings fr = new FirstRatings();
        myMovies = fr.loadMovies(moviefile);
        myRaters = fr.loadRaters(ratingsfile);
    }
    
    public int getMovieSize(){
        return myMovies.size();
    }
    
    public int getRaterSize(){
        return myRaters.size();
    }
    
    private double getAverageByID(String id, int minimalRaters){
        double sum = 0.0;
        int count = 0;
        
        for(Rater r: myRaters){
            double rating = r.getRating(id);
            if(rating!=-1){
                sum+=rating;
                count++;
            }
        }
        if(count>=minimalRaters)
            return sum/count;
            
        return 0.0;
    }
    
    public ArrayList<Rating> getAverageRatings(int minimalRaters){
        ArrayList<Rating> avgRatings = new ArrayList<Rating>();
        for(Movie m : myMovies){
            double avg = getAverageByID(m.getID(), minimalRaters);
            if(avg!=0.0){
                Rating r = new Rating(m.getID(), avg);
                avgRatings.add(r);
            }
        }
        
        return avgRatings;
    }
    
    public String getTitle(String id){
        for(Movie m : myMovies){
            if(m.getID().equals(id))
                return m.getTitle();
        }
        return "ID was not found";
    }
    public String getID(String title){
        for(Movie m : myMovies){
            if(m.getTitle().equals(title))
                return m.getID();
        }
        return "NO SUCH TITLE";
    }
}