package com.mygroup.Services;

import com.mygroup.Models.SpecialityModel;
import com.mygroup.Models.TeacherModel;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.SQLException;

public class TeacherService extends BaseService{

    public TeacherService() throws SQLException {
        super();
        this.nameOfModel = "teachers";
    }
}
