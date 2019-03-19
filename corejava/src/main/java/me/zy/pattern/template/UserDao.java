package me.zy.pattern.template;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

public class UserDao extends JdbcTemplate{
    public UserDao(DataSource dataSource){
        super(dataSource);
    }

    public List<?> executeQuery() {
        String sql = "select * from user";
        return (List<?>) super.executeQuery(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int num) throws Exception {
                User user = new User();
                user.setName(resultSet.getString("user_name"));//数据库字段
                user.setPasswd(resultSet.getString("password"));
                return user;
            }
        },null);
    }
}
