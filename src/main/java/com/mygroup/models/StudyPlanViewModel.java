package com.mygroup.models;

public class StudyPlanViewModel extends BaseModel {
    private final String name;
    private final String specialityName;
    private final int course;

    public StudyPlanViewModel(int id, String name, String specialityName, int course) {
        super(id);
        this.name = name;
        this.specialityName = specialityName;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public String getSpecialityName() {
        return specialityName;
    }
}
