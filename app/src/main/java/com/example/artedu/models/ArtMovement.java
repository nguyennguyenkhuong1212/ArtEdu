package com.example.artedu.models;

public class ArtMovement {
    private String name;
    private String period;
    private String description;

    public ArtMovement(String name, String period, String description) {
        this.name = name;
        this.period = period;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
