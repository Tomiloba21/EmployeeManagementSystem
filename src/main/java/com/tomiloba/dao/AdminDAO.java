package com.tomiloba.dao;

import com.tomiloba.bean.Admin;

import java.sql.SQLException;

public interface AdminDAO {
    public boolean validate(Admin admin) throws SQLException, ClassNotFoundException;
}
