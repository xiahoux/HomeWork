package ru;

public class Lamp {
    boolean isOn;
    String color;
    int brightness;

    public Lamp(String color, int brightness) {
        this.color = color;
        this.brightness = brightness;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    @Override
    public String toString() {
        return "Цвет лампы: " + color + "\nПитание: " + isOn + "\nЯркость: " + brightness;
    }
}
