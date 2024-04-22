package me.joaostitch.springboot.dto;

public class CarDTOPostBody extends CarDTO{

    private Boolean replaceable=false;

    public Boolean getReplaceable() {
        return replaceable;
    }

    public void setReplaceable(Boolean replaceable) {
        this.replaceable = replaceable;
    }
}
