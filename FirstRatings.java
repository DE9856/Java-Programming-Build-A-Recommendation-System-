import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;

public class FirstRatings{
    public ArrayList<Movie> loadMovies(String filename){
        ArrayList<Movie> movies = new ArrayList<Movie>();
        FileResource fr = new FileResource(filename);
        for(CSVRecord rec : fr.getCSVParser()){
            String id = rec.get("id");
            String title = rec.get("title");
            String year = (rec.get("year"));
            String country = rec.get("country");
            String genre = rec.get("genre");
            String director = rec.get("director");
            int minutes = Integer.parseInt(rec.get("minutes"));
            String poster = rec.get("poster");
            
            Movie m = new Movie(id, title, year, genre, director, country, poster, minutes);
            movies.add(m);
        }
        
        return movies;
    }
    
    public void testLoadMovies(){
        ArrayList <Movie> movies = loadMovies("data/ratedmovies_short.csv");
        System.out.println("Number of movies: "+movies.size());
        for(Movie m : movies){
            System.out.println(m);
        }
    }
    
    public ArrayList<Rater> loadRaters(String filename){
    ArrayList<Rater> raters = new ArrayList<Rater>();
    FileResource fr = new FileResource("data/ratings_short.csv");
    
    for(CSVRecord rec: fr.getCSVParser()){
        String raterID = rec.get("rater_id");
        String movieID = rec.get("movie_id");
        double rating = Double.parseDouble(rec.get("rating"));
        
        Rater myRater = null;
        
        for(Rater r : raters){
            if(r.getID().equals(raterID)){
                myRater = r;
                break;
            }
        }
        if(myRater == null){
            myRater = new EfficientRater(raterID);
            raters.add(myRater);
        }
        myRater.addRating(movieID, rating);
    }
    return raters;
}
    
    public void testLoadRaters(){
        ArrayList<Rater> raters = loadRaters("data/ratings_short.csv");
        System.out.println("Number of raters: "+raters.size());
        
        for(Rater r: raters){
            System.out.println("Rater "+r.getID() + " has " + r.numRatings() + " ratings");
        }
    }

}