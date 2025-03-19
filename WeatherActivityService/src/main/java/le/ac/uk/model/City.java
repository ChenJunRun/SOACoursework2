package le.ac.uk.model;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String postcode;
    private double latitude;
    private double longitude;
    private String town;
    private String region;
    private String country;
    private String country_string;

    public City(int id, String postcode, double latitude, double longitude, String town, String region, String country, String country_string) {
        this.id = id;
        this.postcode = postcode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.town = town;
        this.region = region;
        this.country = country;
        this.country_string = country_string;
    }

    public City() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry_string() {
        return country_string;
    }

    public void setCountry_string(String country_string) {
        this.country_string = country_string;
    }
}
