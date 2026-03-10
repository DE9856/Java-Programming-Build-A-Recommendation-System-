import java.util.*;
public class MovieRunnerAverage{
    public void printAverageRatings(){
        SecondRatings sr = new SecondRatings("data/ratedmovies_short.csv", "data/ratings_short.csv");
        
        System.out.println("Number of movies: " + sr.getMovieSize());
        System.out.println("Number of raters: " + sr.getRaterSize());
        
        ArrayList<Rating> avgRatings = sr.getAverageRatings(3);
        Collections.sort(avgRatings);
        
        for(Rating r : avgRatings){
            System.out.println(r.getValue() + " "+sr.getTitle(r.getItem()));
        }
    }
    
    public void getAverageRatingOneMovie(){
        SecondRatings sr = new SecondRatings("data/ratedmovies_short.csv","data/ratings_short.csv");
        String id = sr.getID("The Godfather");
        ArrayList<Rating> avgRatings = sr.getAverageRatings(1);
        for(Rating r : avgRatings){
            if(r.getItem().equals(id)){
                System.out.println(r.getValue());
            }
        }
    }
}