package th.ac.ku.atm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import th.ac.ku.atm.model.Customer;
import th.ac.ku.atm.service.customerService;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {

    @Autowired
    private customerService CustomerService;

    @GetMapping
    public List<Customer> getAll()
    {
        return CustomerService.getCustomers();
    }

    @GetMapping("/{id}")
    public Customer getOne(@PathVariable int id)
    {
        return  CustomerService.findCustomer(id);
    }
}
