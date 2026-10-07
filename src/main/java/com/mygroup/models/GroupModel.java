package com.mygroup.models;


public class GroupModel extends BaseModel{
    private final int specialityId;
    private final String name;
    private final int course;

    public GroupModel(int id, int specialityId, String group, int course) {
        super(id);
        this.specialityId = specialityId;
        this.name = group;
        this.course = course;
    }

    public GroupModel(int specialityId, String group, int course) {
        super(0);
        this.specialityId = specialityId;
        this.name = group;
        this.course = course;
    }

    public int getSpecialityId() {
        return specialityId;
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }
}
