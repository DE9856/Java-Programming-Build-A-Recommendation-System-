import java.util.ArrayList;

public class ThirdRatings {
    private ArrayList<Rater> myRaters;

    public ThirdRatings() {
        this("ratings.csv");
    }

    public ThirdRatings(String ratingsfile) {
        FirstRatings fr = new FirstRatings();
        myRaters = fr.loadRaters(ratingsfile);
    }

    public int getRaterSize() {
        return myRaters.size();
    }

    private double getAverageByID(String id, int minimalRaters) {
        double sum = 0.0;
        int count = 0;

        for (Rater r : myRaters) {
            double value = r.getRating(id);
            if (value != -1) {
                sum += value;
                count++;
            }
        }

        if (count >= minimalRaters) {
            return sum / count;
        }
        return 0.0;
    }

    public ArrayList<Rating> getAverageRatings(int minimalRaters) {
        return getAverageRatingsByFilter(minimalRaters, new TrueFilter());
    }

    public ArrayList<Rating> getAverageRatingsByFilter(int minimalRaters, Filter filterCriteria) {
        ArrayList<Rating> answer = new ArrayList<Rating>();
        ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);

        for (String id : movies) {
            double avg = getAverageByID(id, minimalRaters);
            if (avg != 0.0) {
                answer.add(new Rating(id, avg));
            }
        }
        return answer;
    }
}