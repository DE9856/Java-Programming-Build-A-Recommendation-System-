import java.util.*;

public class RecommendationRunner implements Recommender {
    
    public ArrayList<String> getItemsToRate() {
        ArrayList<String> itemsToRate = new ArrayList<String>();
        
        MovieDatabase.initialize("ratedmoviesfull.csv");
        
        itemsToRate.add("0120737"); // The Lord of the Rings: The Fellowship of the Ring
        itemsToRate.add("0372784"); // Batman Begins
        itemsToRate.add("0993846"); // The Wolf of Wall Street
        itemsToRate.add("0898266"); // The Hunger Games
        itemsToRate.add("1201607"); // Harry Potter and the Deathly Hallows: Part 2
        itemsToRate.add("1345836"); // The Dark Knight Rises
        itemsToRate.add("1375666"); // Inception
        itemsToRate.add("0383574"); // Pirates of the Caribbean: Dead Man's Chest
        itemsToRate.add("2488496"); // Star Wars: The Force Awakens
        itemsToRate.add("0816692"); // Interstellar
        
        return itemsToRate;
    }
    
    public void printRecommendationsFor(String webRaterID) {
        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");
        
        FourthRatings fr = new FourthRatings();
        ArrayList<Rating> recommendations = fr.getSimilarRatings(webRaterID, 20, 5);
        
        if (recommendations.size() == 0) {
            System.out.println("<h2>No recommendations available.</h2>");
            System.out.println("<p>Please try rating more movies.</p>");
            return;
        }
        
        System.out.println("<html>");
        System.out.println("<head>");
        System.out.println("<style>");
        System.out.println("table {border-collapse: collapse; width: 100%;}");
        System.out.println("th, td {border: 1px solid black; padding: 8px; text-align: left;}");
        System.out.println("th {background-color: #f2f2f2;}");
        System.out.println("img {width: 100px;}");
        System.out.println("</style>");
        System.out.println("</head>");
        System.out.println("<body>");
        System.out.println("<h2>Recommended Movies For You</h2>");
        System.out.println("<table>");
        System.out.println("<tr><th>Poster</th><th>Title</th><th>Year</th><th>Genre</th><th>Minutes</th><th>Director</th></tr>");
        
        int count = 0;
        for (Rating r : recommendations) {
            String id = r.getItem();
            System.out.println("<tr>");
            System.out.println("<td><img src=\"" + MovieDatabase.getPoster(id) + "\"></td>");
            System.out.println("<td>" + MovieDatabase.getTitle(id) + "</td>");
            System.out.println("<td>" + MovieDatabase.getYear(id) + "</td>");
            System.out.println("<td>" + MovieDatabase.getGenres(id) + "</td>");
            System.out.println("<td>" + MovieDatabase.getMinutes(id) + "</td>");
            System.out.println("<td>" + MovieDatabase.getDirector(id) + "</td>");
            System.out.println("</tr>");
            
            count++;
            if (count == 10) break;
        }
        
        System.out.println("</table>");
        System.out.println("</body>");
        System.out.println("</html>");
    }
}