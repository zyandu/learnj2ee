package me.zy.pattern.template;

import java.sql.ResultSet;

public interface RowMapper<T> {
    T mapRow(ResultSet resultSet,int num) throws Exception;
}
