package me.joaostitch.springboot.dto;

public class CarDTOPatchBody extends CarDTO{

    private Boolean available;
    private Boolean replaceable;

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Boolean getReplaceable() {
        return replaceable;
    }

    public void setReplaceable(Boolean replaceable) {
        this.replaceable = replaceable;
    }
}
