package BL;

import java.io.Serializable;

public class WeatherStation implements Serializable {

    private String place;
    private int seaLevel;
    private double temperature;
    private int humi;

    public WeatherStation(String place, int seaLevel, double temperature, int humi) throws Exception {
        if (temperature >= -35 && temperature <= 45 && humi >= 0 && humi <= 100) {
            this.place = place;
            this.seaLevel = seaLevel;
            this.temperature = temperature;
            this.humi = humi;
        } else {
            throw new Exception("No valid values");
        }

    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(int seaLevel) {
        this.seaLevel = seaLevel;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) throws Exception {
        if (temperature >= -35 && temperature <= 45) {
            this.temperature = temperature;
        } else {
            throw new Exception("Not a valid temperature");
        }

    }

    public int getHumi() {
        return humi;
    }

    public void setHumi(int humi) throws Exception {
        if (humi >= 0 && humi <= 100) {
            this.humi = humi;
        } else {
            throw new Exception("Not a valid Humidity");
        }

    }

}
