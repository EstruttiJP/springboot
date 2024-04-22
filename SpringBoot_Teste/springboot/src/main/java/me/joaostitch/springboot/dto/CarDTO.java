package me.joaostitch.springboot.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CarDTO {

    @NotEmpty(message = "this field model cannot be null or empty")
    protected String model;
    @NotEmpty(message = "this field model cannot be null or empty")
    protected String color;
    @NotNull(message = "this field model cannot be null")
    protected Integer year;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
