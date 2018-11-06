package BL;

import java.util.Comparator;

public class SortByName implements Comparator<WeatherStation> {

    @Override
    public int compare(WeatherStation t, WeatherStation t1) {
        return t.getPlace().compareTo(t1.getPlace());
    }

}
