package next.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.jdbc.ConnectionManager;
import next.model.User;
import next.support.context.JdbcTemplate;
import next.support.context.PreparedStatementSetter;
import next.support.context.RowMapper;

public class UserDao {
    public void insert(User user) throws SQLException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
        jdbcTemplate.excuteUpdate(sql, user.getUserId(), user.getPassword(), user.getName(), user.getEmail());
    }


    public void update(User user) throws SQLException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        String sql = "UPDATE USERS SET userId = ?, password = ?, name = ?, email = ? WHERE userId = ?";
        jdbcTemplate.excuteUpdate(sql, user.getUserId(), user.getPassword(), user.getName(), user.getEmail(), user.getUserId());
    }


    public List<User> findAll() throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionManager.getConnection();
            String sql = "SELECT userId, password, name, email FROM USERS";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            User user = null;
            ArrayList<User> list = new ArrayList<>();
            while(rs.next()) {
                user = new User(rs.getString("userId"), rs.getString("password"), rs.getString("name"),
                        rs.getString("email"));
                list.add(user);
            }
            return list;

        } finally {
            if (rs != null){
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public User findByUserId(String userId) throws SQLException {
        RowMapper<User> rm = new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs) throws SQLException {

                return new User(
                        rs.getString("userId"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("email"));
            }
        };
        JdbcTemplate JdbcTemplate = new JdbcTemplate();
        String sql = "SELECT * FROM USERS WHERE userId=?";

        return JdbcTemplate.excuteQuery(sql, rm, userId);
    }

}
