package com.mygroup.models;

public class StudyPlanModel extends BaseModel {
    private final String name;
    private final int specialityId;
    private final int course;

    public StudyPlanModel(int id, String name, int specialityId, int course) {
        super(id);
        this.name = name;
        this.specialityId = specialityId;
        this.course = course;
    }

    public StudyPlanModel(String name, int specialityId, int course) {
        super(0);
        this.name = name;
        this.specialityId = specialityId;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public int getSpecialityId() {
        return specialityId;
    }
}
