package le.ac.uk.model;

import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class WeatherConstraints {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private final double minTemperature =5;
    private final double maxTemperature=20;
    private final double minPrecipitation=0;
    private final double maxPrecipitation=1;
    private final double minWindSpeed=0;
    private final double maxWindSpeed=25;

    public int getId() {
        return id;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public double getMinPrecipitation() {
        return minPrecipitation;
    }

    public double getMaxPrecipitation() {
        return maxPrecipitation;
    }

    public double getMinWindSpeed() {
        return minWindSpeed;
    }

    public double getMaxWindSpeed() {
        return maxWindSpeed;
    }
}
