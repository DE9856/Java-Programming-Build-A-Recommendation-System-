import java.util.ArrayList;
import java.util.Collections;

public class MovieRunnerWithFilters {

    public void printAverageRatings() {
        String moviefile = "data/ratedmovies_short.csv";
        String ratingsfile = "data/ratings_short.csv";

        ThirdRatings tr = new ThirdRatings(ratingsfile);
        System.out.println("read data for " + tr.getRaterSize() + " raters");

        MovieDatabase.initialize(moviefile);
        System.out.println("read data for " + MovieDatabase.size() + " movies");

        ArrayList<Rating> list = tr.getAverageRatings(1);
        System.out.println("found " + list.size() + " movies");

        Collections.sort(list);
        for (Rating r : list) {
            System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()));
        }
    }

    public void printAverageRatingsByYear() {
        String moviefile = "data/ratedmovies_short.csv";
        String ratingsfile = "data/ratings_short.csv";

        ThirdRatings tr = new ThirdRatings(ratingsfile);
        System.out.println("read data for " + tr.getRaterSize() + " raters");

        MovieDatabase.initialize(moviefile);
        System.out.println("read data for " + MovieDatabase.size() + " movies");

        Filter f = new YearAfterFilter(2000);
        ArrayList<Rating> list = tr.getAverageRatingsByFilter(1, f);

        System.out.println("found " + list.size() + " movies");
        Collections.sort(list);

        for (Rating r : list) {
            String id = r.getItem();
            System.out.println(r.getValue() + " " + MovieDatabase.getYear(id) + " " + MovieDatabase.getTitle(id));
        }
    }

    public void printAverageRatingsByGenre() {
        String moviefile = "data/ratedmovies_short.csv";
        String ratingsfile = "data/ratings_short.csv";

        ThirdRatings tr = new ThirdRatings(ratingsfile);
        System.out.println("read data for " + tr.getRaterSize() + " raters");

        MovieDatabase.initialize(moviefile);
        System.out.println("read data for " + MovieDatabase.size() + " movies");

        Filter f = new GenreFilter("Crime");
        ArrayList<Rating> list = tr.getAverageRatingsByFilter(1, f);

        System.out.println("found " + list.size() + " movies");
        Collections.sort(list);

        for (Rating r : list) {
            String id = r.getItem();
            System.out.println(r.getValue() + " " + MovieDatabase.getTitle(id));
            System.out.println("    " + MovieDatabase.getGenres(id));
        }
    }

    public void printAverageRatingsByMinutes() {
        String moviefile = "data/ratedmovies_short.csv";
        String ratingsfile = "data/ratings_short.csv";

        ThirdRatings tr = new ThirdRatings(ratingsfile);
        System.out.println("read data for " + tr.getRaterSize() + " raters");

        MovieDatabase.initialize(moviefile);
        System.out.println("read data for " + MovieDatabase.size() + " movies");

        Filter f = new MinutesFilter(110, 170);
        ArrayList<Rating> list = tr.getAverageRatingsByFilter(1, f);

        System.out.println("found " + list.size() + " movies");
        Collections.sort(list);

        for (Rating r : list) {
            String id = r.getItem();
            System.out.println(r.getValue() + " Time: " + MovieDatabase.getMinutes(id) + " " + MovieDatabase.getTitle(id));
        }
    }

    public void printAverageRatingsByDirectors() {
        String moviefile = "data/ratedmovies_short.csv";
        String ratingsfile = "data/ratings_short.csv";

        ThirdRatings tr = new ThirdRatings(ratingsfile);
        System.out.println("read data for " + tr.getRaterSize() + " raters");

        MovieDatabase.initialize(moviefile);
        System.out.println("read data for " + MovieDatabase.size() + " movies");

        Filter f = new DirectorsFilter("Charles Chaplin,Michael Mann,Spike Jonze");
        ArrayList<Rating> list = tr.getAverageRatingsByFilter(1, f);

        System.out.println("found " + list.size() + " movies");
        Collections.sort(list);

        for (Rating r : list) {
            String id = r.getItem();
            System.out.println(r.getValue() + " " + MovieDatabase.getTitle(id));
            System.out.println("    " + MovieDatabase.getDirector(id));
        }
    }

    public void printAverageRatingsByYearAfterAndGenre() {
        String moviefile = "data/ratedmovies_short.csv";
        String ratingsfile = "data/ratings_short.csv";

        ThirdRatings tr = new ThirdRatings(ratingsfile);
        System.out.println("read data for " + tr.getRaterSize() + " raters");

        MovieDatabase.initialize(moviefile);
        System.out.println("read data for " + MovieDatabase.size() + " movies");

        AllFilters af = new AllFilters();
        af.addFilter(new YearAfterFilter(1980));
        af.addFilter(new GenreFilter("Romance"));

        ArrayList<Rating> list = tr.getAverageRatingsByFilter(1, af);

        if (list.size() == 1) {
            System.out.println("1 movie matched");
        } else {
            System.out.println(list.size() + " movies matched");
        }

        Collections.sort(list);
        for (Rating r : list) {
            String id = r.getItem();
            System.out.println(r.getValue() + " " + MovieDatabase.getYear(id) + " " + MovieDatabase.getTitle(id));
            System.out.println("    " + MovieDatabase.getGenres(id));
        }
    }

    public void printAverageRatingsByDirectorsAndMinutes() {
        String moviefile = "data/ratedmovies_short.csv";
        String ratingsfile = "data/ratings_short.csv";

        ThirdRatings tr = new ThirdRatings(ratingsfile);
        System.out.println("read data for " + tr.getRaterSize() + " raters");

        MovieDatabase.initialize(moviefile);
        System.out.println("read data for " + MovieDatabase.size() + " movies");

        AllFilters af = new AllFilters();
        af.addFilter(new MinutesFilter(30, 170));
        af.addFilter(new DirectorsFilter("Spike Jonze,Michael Mann,Charles Chaplin,Francis Ford Coppola"));

        ArrayList<Rating> list = tr.getAverageRatingsByFilter(1, af);

        System.out.println("found " + list.size() + " movies");
        Collections.sort(list);

        for (Rating r : list) {
            String id = r.getItem();
            System.out.println(r.getValue() + " Time: " + MovieDatabase.getMinutes(id) + " " + MovieDatabase.getTitle(id));
            System.out.println("    " + MovieDatabase.getDirector(id));
        }
    }
}