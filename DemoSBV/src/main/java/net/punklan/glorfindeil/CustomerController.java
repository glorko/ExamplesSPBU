package net.punklan.glorfindeil;

import java.util.List;

/**
 * Created by st020794 on 21.04.2017.
 */
public interface CustomerController {

    public void saveNewCustomer(Customer toCreate);

    public List<Customer> getAllCustomers();

    public void deleteCustomer(Long customerId);

    public Customer getById(Long customerId);
}
