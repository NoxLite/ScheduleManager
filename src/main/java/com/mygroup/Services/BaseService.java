package com.mygroup.Services;

import java.sql.Connection;

public class BaseService {
    protected final Connection connection;

    BaseService(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

}
