public class MinutesFilter implements Filter {
    private int myMin;
    private int myMax;

    public MinutesFilter(int min, int max) {
        myMin = min;
        myMax = max;
    }

    public boolean satisfies(String id) {
        int time = MovieDatabase.getMinutes(id);
        return time >= myMin && time <= myMax;
    }
}