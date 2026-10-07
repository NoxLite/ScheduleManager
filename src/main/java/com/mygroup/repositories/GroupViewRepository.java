package com.mygroup.repositories;

import com.mygroup.models.GroupViewModel;
import java.sql.SQLException;
import java.util.List;

public class GroupViewRepository extends BaseRepository<GroupViewModel> {
    public GroupViewRepository() {
        super();
        this.nameOfModel = "[group]";
    }

    public List<GroupViewModel> getAll() throws SQLException {
        return getAll(
                "SELECT g.id, s.name speciality_name, g.course, g.name FROM [group] g JOIN speciality s ON g.speciality = s.id;",
                r -> new GroupViewModel(
                        r.getInt("id"),
                        r.getString("speciality_name"),
                        r.getString("name"),
                        r.getInt("course")
                ));
    }
}
