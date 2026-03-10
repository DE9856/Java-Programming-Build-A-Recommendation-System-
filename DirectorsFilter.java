public class DirectorsFilter implements Filter {
    private String myDirectors;

    public DirectorsFilter(String directors) {
        myDirectors = directors;
    }

    public boolean satisfies(String id) {
        String movieDirectors = MovieDatabase.getDirector(id);
        String[] directorList = myDirectors.split(",");

        for (String dir : directorList) {
            if (movieDirectors.contains(dir.trim())) {
                return true;
            }
        }
        return false;
    }
}