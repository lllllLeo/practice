package me.yujun.springbootjdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
public class H2Runner implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(H2Runner.class);

    //    기본적으로 DataSource가 빈으로 등록되어있으니까 주입받아서 사용가능
//    어디서 빈으로 등록된거지
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        try (Connection connection = dataSource.getConnection()) {
//        connection.setAutoCommit(false);  // 해서 트랜잭션 적용
            logger.info(connection.getMetaData().getURL());
            logger.info(connection.getMetaData().getUserName());

        /*
        CREATE TABLE USER (ID INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id))
        INSERT INTO USER VALUES (1, ‘keesun’)
        */

            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE USER (ID INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id))";
            statement.executeUpdate(sql);
//            만들어 진건가 확인하고 싶잖아요 오른쪽에 Database에 커넥션 정보를 만들면 된다~~~
        }

//        connection.close();
        jdbcTemplate.execute("INSERT INTO USER VALUES (1, 'yujun')");
    }
}
