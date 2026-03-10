import java.util.*;

public class MovieRunnerSimilarRatings {

    public void printAverageRatings() {
        String moviefile = "data/ratedmovies_short.csv";
        String ratingsfile = "data/ratings_short.csv";

        FourthRatings fr = new FourthRatings();

        MovieDatabase.initialize(moviefile);
        RaterDatabase.initialize(ratingsfile);

        System.out.println("read data for " + RaterDatabase.size() + " raters");
        System.out.println("read data for " + MovieDatabase.size() + " movies");

        ArrayList<Rating> list = fr.getAverageRatings(1);
        System.out.println("found " + list.size() + " movies");

        Collections.sort(list);
        for (Rating r : list) {
            System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()));
        }
    }

    public void printAverageRatingsByYearAfterAndGenre() {
        String moviefile = "data/ratedmovies_short.csv";
        String ratingsfile = "data/ratings_short.csv";

        FourthRatings fr = new FourthRatings();

        MovieDatabase.initialize(moviefile);
        RaterDatabase.initialize(ratingsfile);

        System.out.println("read data for " + RaterDatabase.size() + " raters");
        System.out.println("read data for " + MovieDatabase.size() + " movies");

        AllFilters af = new AllFilters();
        af.addFilter(new YearAfterFilter(1980));
        af.addFilter(new GenreFilter("Romance"));

        ArrayList<Rating> list = fr.getAverageRatingsByFilter(1, af);

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

    public void printSimilarRatings() {
        String moviefile = "data/ratedmoviesfull.csv";
        String ratingsfile = "data/ratings.csv";

        MovieDatabase.initialize(moviefile);
        RaterDatabase.initialize(ratingsfile);

        FourthRatings fr = new FourthRatings();
        ArrayList<Rating> list = fr.getSimilarRatings("65", 20, 5);

        for (Rating r : list) {
            System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()));
        }
    }

    public void printSimilarRatingsByGenre() {
    System.out.println("Method started");

    String moviefile = "data/ratedmoviesfull.csv";
    String ratingsfile = "data/ratings.csv";

    MovieDatabase.initialize(moviefile);
    RaterDatabase.initialize(ratingsfile);

    FourthRatings fr = new FourthRatings();
    GenreFilter gf = new GenreFilter("Action");

    ArrayList<Rating> list = fr.getSimilarRatingsByFilter("65", 20, 1, gf);

    System.out.println("Movies found: " + list.size());

    int count = 0;
    for (Rating r : list) {
        String id = r.getItem();
        System.out.println(r.getValue() + " " + MovieDatabase.getTitle(id));
        System.out.println("    " + MovieDatabase.getGenres(id));
        count++;
        if (count == 10) break;
    }
    }

    public void printSimilarRatingsByDirector() {
        System.out.println("Method Started");
        String moviefile = "data/ratedmoviesfull.csv";
        String ratingsfile = "data/ratings.csv";

        MovieDatabase.initialize(moviefile);
        RaterDatabase.initialize(ratingsfile);

        FourthRatings fr = new FourthRatings();
        DirectorsFilter df = new DirectorsFilter("Clint Eastwood,Sydney Pollack,David Cronenberg,Oliver Stone");

        ArrayList<Rating> list = fr.getSimilarRatingsByFilter("1034", 10, 3, df);

        for (Rating r : list) {
            String id = r.getItem();
            System.out.println(r.getValue() + " " + MovieDatabase.getTitle(id));
            System.out.println("    " + MovieDatabase.getDirector(id));
        }
    }

    public void printSimilarRatingsByGenreAndMinutes() {
        System.out.println("Method Started");
        String moviefile = "data/ratedmoviesfull.csv";
        String ratingsfile = "data/ratings.csv";

        MovieDatabase.initialize(moviefile);
        RaterDatabase.initialize(ratingsfile);

        FourthRatings fr = new FourthRatings();

        AllFilters af = new AllFilters();
        af.addFilter(new GenreFilter("Adventure"));
        af.addFilter(new MinutesFilter(100, 200));

        ArrayList<Rating> list = fr.getSimilarRatingsByFilter("65", 10, 5, af);

        for (Rating r : list) {
            String id = r.getItem();
            System.out.println(r.getValue() + " " + MovieDatabase.getMinutes(id) + " " + MovieDatabase.getTitle(id));
            System.out.println("    " + MovieDatabase.getGenres(id));
        }
    }

    public void printSimilarRatingsByYearAfterAndMinutes() {
        System.out.println("Method Started");
        String moviefile = "data/ratedmoviesfull.csv";
        String ratingsfile = "data/ratings.csv";

        MovieDatabase.initialize(moviefile);
        RaterDatabase.initialize(ratingsfile);

        FourthRatings fr = new FourthRatings();

        AllFilters af = new AllFilters();
        af.addFilter(new YearAfterFilter(2000));
        af.addFilter(new MinutesFilter(80, 100));

        ArrayList<Rating> list = fr.getSimilarRatingsByFilter("65", 10, 5, af);

        for (Rating r : list) {
            String id = r.getItem();
            System.out.println(r.getValue() + " " + MovieDatabase.getYear(id) + " " + MovieDatabase.getMinutes(id) + " " + MovieDatabase.getTitle(id));
        }
    }
    
}