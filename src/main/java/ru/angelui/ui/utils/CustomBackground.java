package ru.angelui.ui.utils;

public class CustomBackground {

    private Integer[] color;
    private float alpha;
    private String image;

    public CustomBackground(String image) {
        this.image = image;
    }

    public CustomBackground(float alpha, String image) {
        this.alpha = alpha;
        this.image = image;
    }

    public CustomBackground(Integer[] color, float alpha) {
        this.color = color;
        this.alpha = alpha;
    }
}
