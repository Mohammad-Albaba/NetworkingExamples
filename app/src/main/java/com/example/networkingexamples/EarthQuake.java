package com.example.networkingexamples;

public class EarthQuake {
    private String daeTime;
    private Double depth;
    private Double lng;
    private Double lat;
    private String source;
    private Double magnitude;

    public EarthQuake() {
    }

    public EarthQuake(String daeTime, Double depth, Double lng, Double lat, String source, Double magnitude) {
        this.daeTime = daeTime;
        this.depth = depth;
        this.lng = lng;
        this.lat = lat;
        this.source = source;
        this.magnitude = magnitude;
    }

    public String getDaeTime() {
        return daeTime;
    }

    public void setDaeTime(String daeTime) {
        this.daeTime = daeTime;
    }

    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(Double magnitude) {
        this.magnitude = magnitude;
    }
}