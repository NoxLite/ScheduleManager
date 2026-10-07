package com.mygroup.models;

import java.sql.ResultSet;

public class BaseModel {
    protected final int id;

    public BaseModel(int id) {

        this.id = id;
    }

    public int getId() {
        return id;
    }
}
