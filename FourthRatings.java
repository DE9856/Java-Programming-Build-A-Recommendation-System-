import java.util.*;

public class FourthRatings {

    public FourthRatings() {
    }

    private double getAverageByID(String id, int minimalRaters) {
        double sum = 0.0;
        int count = 0;

        for (Rater r : RaterDatabase.getRaters()) {
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

    private double dotProduct(Rater me, Rater r) {
        double sum = 0.0;

        for (String item : me.getItemsRated()) {
            if (r.hasRating(item)) {
                double meRating = me.getRating(item) - 5;
                double rRating = r.getRating(item) - 5;
                sum += meRating * rRating;
            }
        }

        return sum;
    }

    private ArrayList<Rating> getSimilarities(String id) {
    ArrayList<Rating> similarities = new ArrayList<Rating>();
    Rater me = RaterDatabase.getRater(id);

    if (me == null) {
        System.out.println("No such rater: " + id);
        return similarities;
    }

    for (Rater r : RaterDatabase.getRaters()) {
        if (!r.getID().equals(id)) {
            double sim = dotProduct(me, r);
            if (sim > 0) {
                similarities.add(new Rating(r.getID(), sim));
            }
        }
    }

    Collections.sort(similarities, Collections.reverseOrder());
    return similarities;
}

    public ArrayList<Rating> getSimilarRatings(String id, int numSimilarRaters, int minimalRaters) {
        return getSimilarRatingsByFilter(id, numSimilarRaters, minimalRaters, new TrueFilter());
    }

    public ArrayList<Rating> getSimilarRatingsByFilter(String id, int numSimilarRaters, int minimalRaters, Filter filterCriteria) {
        ArrayList<Rating> similarities = getSimilarities(id);
        ArrayList<Rating> recommended = new ArrayList<Rating>();
        ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);

        for (String movieID : movies) {
            double weightedSum = 0.0;
            int count = 0;

            for (int i = 0; i < similarities.size() && i < numSimilarRaters; i++) {
                Rating simRating = similarities.get(i);
                String raterID = simRating.getItem();
                double similarity = simRating.getValue();

                Rater r = RaterDatabase.getRater(raterID);
                if (r.hasRating(movieID)) {
                    weightedSum += similarity * r.getRating(movieID);
                    count++;
                }
            }

            if (count >= minimalRaters) {
                double weightedAverage = weightedSum / count;
                recommended.add(new Rating(movieID, weightedAverage));
            }
        }

        Collections.sort(recommended, Collections.reverseOrder());
        return recommended;
    }
}