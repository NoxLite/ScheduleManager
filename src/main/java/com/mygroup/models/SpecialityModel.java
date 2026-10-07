package com.mygroup.models;


public class SpecialityModel extends BaseModel {
    private final String name;
    private final int duration;

    public SpecialityModel(int id, String name, int duration) {
        super(id);
        this.name = name;
        this.duration = duration;
    }

    public SpecialityModel(String name, int duration) {
        super(0);
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return getName();
    }
}
