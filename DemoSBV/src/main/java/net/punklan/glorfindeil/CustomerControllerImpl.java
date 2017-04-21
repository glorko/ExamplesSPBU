package net.punklan.glorfindeil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by st020794 on 21.04.2017.
 */
@Controller
public class CustomerControllerImpl implements CustomerController {

    @Autowired
    JdbcTemplate template;

    String query = "INSERT INTO customers (first_name, last_name) VALUES (?,?);";


    @Override
    public void saveNewCustomer(Customer toCreate) {
        template.execute(query, new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                preparedStatement.setString(1, toCreate.getFirstName());
                preparedStatement.setString(2, toCreate.getLastName());
                return preparedStatement.execute();
            }
        });
    }

    @Override
    public List<Customer> getAllCustomers() {
        return template.query
                ("SELECT * FROM customers;",
                        new CustomerRowMapper());
    }

    @Override
    public void deleteCustomer(Long customerId) {
        template.execute("delete from customers where id = " + customerId);

    }

    @Override
    public Customer getById(Long customerId) {
       return template.query
                ("SELECT * FROM customers where id = " + customerId,
                        new CustomerRowMapper()).stream().findFirst().orElse(null);
    }
}
