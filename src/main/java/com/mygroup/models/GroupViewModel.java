package com.mygroup.models;


public class GroupViewModel extends BaseModel {
    private final String speciality;
    private final String name;
    private final int course;

    public GroupViewModel(int id, String speciality, String name, int course) {
        super(id);
        this.speciality = speciality;
        this.name = name;
        this.course = course;
    }

    public GroupViewModel(String speciality, String name, int course) {
        super(0);
        this.speciality = speciality;
        this.name = name;
        this.course = course;
    }

    public String getSpeciality() {
        return speciality;
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }
}
