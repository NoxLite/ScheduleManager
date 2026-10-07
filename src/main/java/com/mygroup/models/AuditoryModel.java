package com.mygroup.models;

public class AuditoryModel extends BaseModel {
    private final String name;

    public AuditoryModel(int id, String name) {
        super(id);
        this.name = name;
    }

    public AuditoryModel(String name) {
        super(0);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
