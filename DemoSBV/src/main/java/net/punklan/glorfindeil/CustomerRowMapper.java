package net.punklan.glorfindeil;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by st020794 on 14.04.2017.
 */
public class CustomerRowMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
        Customer cust = new Customer();
        cust.setFirstName(resultSet.getString("first_name"));
        cust.setLastName(resultSet.getString("last_name"));
        cust.setId(resultSet.getLong("id"));
        return cust;
    }
}
