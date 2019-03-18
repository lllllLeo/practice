package next.support.jdbc;

import core.jdbc.ConnectionManager;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTemplate {

    public void excuteUpdate(String sql, PreparedStatementSetter pss) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement(sql);
            pss.setParameters(pstmt);

            pstmt.executeUpdate();
        } catch (SQLException e){
            throw new DataAccessException(e);
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }

                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new DataAccessException(e);
            }
        }
    }

    public void excuteUpdate(String sql, Object... parameters) {
        excuteUpdate(sql, createPreparedStatementSetter(parameters));
    }

    // 의존관계를 제거해야 User객체 뿐만아니라 다른 객체에서도 재사용이 가능함

    public <T> T excuteQuery(String sql, RowMapper<T> rm, PreparedStatementSetter pss) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement(sql);
            pss.setParameters(pstmt);

            rs = pstmt.executeQuery();

            if(!rs.next()){
                return null;
            }

            return rm.mapRow(rs);
        } catch (SQLException e){
            throw new DataAccessException(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new DataAccessException(e);
            }
        }
    }

    public <T> T excuteQuery(String sql, RowMapper<T> rm, Object... parameters){
        return excuteQuery(sql, rm, createPreparedStatementSetter(parameters));
    }

    private PreparedStatementSetter createPreparedStatementSetter(Object[] parameters) {
        return new PreparedStatementSetter() {
            @Override
            public void setParameters(PreparedStatement pstmt) throws SQLException {
                for (int i = 0; i < parameters.length; i++) {
                    pstmt.setObject(i + 1, parameters[i]);
                }
            }
        };
    }
}
