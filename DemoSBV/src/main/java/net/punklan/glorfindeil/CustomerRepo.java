package net.punklan.glorfindeil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by st020794 on 21.04.2017.
 */
@RestController("api/customer")
public class CustomerRepo {

    @Autowired
    CustomerController controller;

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> getAll() {
        return controller.getAllCustomers();
    }

    ;

    @RequestMapping(value = "api/customer/{id}", method = RequestMethod.GET)
    public Customer getById(@PathVariable(name = "id") Long id) {
        return controller.getById(id);
    }

    ;

    @RequestMapping(value = "api/customer/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(name = "id") Long customerId) {
        controller.deleteCustomer(customerId);
    }

    ;

    @RequestMapping(method = RequestMethod.POST)
    public void createCustomer(@RequestBody Customer customer) {
        controller.saveNewCustomer(customer);
    }
}
