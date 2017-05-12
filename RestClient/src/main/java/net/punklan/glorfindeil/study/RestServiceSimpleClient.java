package net.punklan.glorfindeil.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.*;

/**
 * Created by st020794 on 21.04.2017.
 */
@Service
public class RestServiceSimpleClient {
    String url = "http://localhost:8080/api/customer";

    @Autowired
    RestTemplate restTemplate;

    public void checkRest() {
        Map paramerters = new HashMap();
        paramerters.put("id", 2);
        restTemplate.delete(url + "/{id}", paramerters);
        Customer c1 = new Customer();
        c1.setFirstName("Ivan");
        c1.setLastName("Jackson");
        c1.setDate(LocalDate.now());
        Customer c2 = new Customer();
        c2.setFirstName("James");
        c2.setLastName("Coward");
        c2.setDate(LocalDate.now());
        restTemplate.postForEntity(url, c1, Customer.class);
        restTemplate.postForEntity(url, c2, Customer.class);

        Customer[] arr = restTemplate.getForEntity(url, Customer[].class).getBody();
        List<Customer> all =
                Arrays.asList(arr);
        System.out.println("all = " + all);
    }
}
