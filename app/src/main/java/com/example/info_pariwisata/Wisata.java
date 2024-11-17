package com.example.info_pariwisata;

public class Wisata {
    private String title;
    private String location;
    private int imageResource;
    private String description;
    private double latitude;
    private double longitude;

    public Wisata(String title, String location, int imageResource, String description, double latitude, double longitude) {
        this.title = title;
        this.location = location;
        this.imageResource = imageResource;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getDescription() {
        return description;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
