package com.example.learnandroid2.utils;

public class MyContext {
    private String color;
    private int icon;
    private String description;

    public MyContext(String color, int icon, String description) {
        this.color = color;
        this.icon = icon;
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
