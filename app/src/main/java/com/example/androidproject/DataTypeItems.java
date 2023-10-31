package com.example.androidproject;

public class DataTypeItems {
    private String name;
    private String description;
    //pic
    //name
    //desc
    //location
    //mig

    public DataTypeItems(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return name;
    }
}
