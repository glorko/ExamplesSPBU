package net.punklan.glorfindeil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class DemoSbvApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoSbvApplication.class, args);
    }


    @Autowired
    JdbcTemplate template;

    String query = "INSERT INTO customers (first_name, last_name) VALUES (?,?);";

    /**/
    @Override
    public void run(String... strings) throws Exception {
        template.execute("CREATE TABLE customers(" +
                "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");
        template.execute("CREATE TABLE boards(" +
                "id SERIAL, board_name VARCHAR(255), customer_id VARCHAR(255))");
        template.execute("ALTER TABLE boards ADD FOREIGN KEY ( customer_id ) REFERENCES customers( id ) ;");
        template.execute(query, new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                preparedStatement.setString(1, "John");
                preparedStatement.setString(2, "Doe");
                return preparedStatement.execute();
            }
        });

        template.execute("INSERT INTO customers (first_name, last_name) VALUES ('Name','Second');");
        List<Customer> result = template.query("SELECT * FROM customers WHERE last_name = 'Doe';", new CustomerRowMapper());
        template.execute("insert into boards (board_name, customer_id)  values ('TestBox','" + result.get(0).getId() + "');");
        try {
            template.execute("INSERT INTO boards (board_name, customer_id)  VALUES ('TestBox','" + 8 + "');");
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Board> boards = template.query
                ("SELECT * FROM boards  JOIN customers ON boards.customer_id = customers.id WHERE customers.first_name = 'John'",
                        (resultSet, i) -> {
                            Board board = new Board();
                            board.setBoardName(resultSet.getString("board_name"));
                            board.setId(resultSet.getLong("id"));
                            return board;
                        });


        boards.stream().map(Board::toString).forEach(System.out::println);


    }
}
