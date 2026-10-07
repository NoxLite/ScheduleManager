package com.mygroup.services;

import com.mygroup.models.GroupViewModel;
import com.mygroup.repositories.GroupViewRepository;

import java.sql.SQLException;
import java.util.List;

public class GroupViewService extends BaseService<GroupViewRepository> {

    public List<GroupViewModel> getAll() throws SQLException {
        return repository.getAll();
    }

}
