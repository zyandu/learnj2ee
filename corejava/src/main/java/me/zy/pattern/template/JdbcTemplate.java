package me.zy.pattern.template;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate {
    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> executeQuery(String sql, RowMapper<?> rowMapper, Object[] values) {
        //加载驱动
        //获取连接
        List<?> result = null;
        try {
            Connection conn = this.getConnection();
            //创建语句集
            PreparedStatement pstm = this.createPreparedStatement(conn,sql);
            //执行语句集
            ResultSet rs = this.executeQuery(pstm,values);
            //处理结果集
            result = this.ParseResultSet(rs,rowMapper);
            //关闭结果集
            this.closeResultSet(rs);
            //关闭语句集
            this.closePreparedStatement(pstm);
            //关闭连接
            this.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    private void closeConnection(Connection conn) throws SQLException {
        //数据库连接池，就不再关闭
        conn.close();
    }


    private void closePreparedStatement(PreparedStatement pstm) throws SQLException {
        pstm.close();
    }

    private void closeResultSet(ResultSet rs) throws SQLException {
        rs.close();
    }

    private List<?> ParseResultSet(ResultSet rs, RowMapper<?> rowMapper) throws Exception {
        List<Object> list = new ArrayList<Object>();
        int rowNum = 1;
        while (rs.next()){
            list.add(rowMapper.mapRow(rs,rowNum++));
        }
        return list;

    }

    public ResultSet executeQuery(PreparedStatement pstm, Object[] values) throws SQLException {
        for(int i=0;i<values.length;i++){
            pstm.setObject(i,values[i]);
        }
        return pstm.executeQuery();
    }

    public PreparedStatement createPreparedStatement(Connection conn,String sql) throws SQLException {
        return conn.prepareStatement(sql);
    }

    public Connection getConnection() throws Exception {
        return this.dataSource.getConnection();
    }

}
