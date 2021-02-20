package th.ac.ku.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.ku.atm.model.Customer;
import th.ac.ku.atm.service.customerService;


@Controller
@RequestMapping("/customer")
public class CustomerController {
    //private  List<Customer> customers = new ArrayList<>();
    private customerService CustomerService;

    public CustomerController(customerService CustomerService) {
        this.CustomerService = CustomerService;
    }


    @RequestMapping
    public  String getCustomerPage(Model model)
    {

        //customers.add(new Customer(1,"Peter",1234));
        //customers.add(new Customer(2,"Nancy",1231));
        //customers.add(new Customer(3,"Rick",1232));
        //customers.add(new Customer(4,"Katherine",1233));
        model.addAttribute("allCustomers", CustomerService.getCustomers());
        return  "customer";
    }

    //Set Parameter Request
    // @RequestMapping("/id")
    //public  String getOneCustomer(int id)
    //{

    //}

    @PostMapping
    public  String registerCustomer(@ModelAttribute Customer customer, Model model){
         //customers.add(customer);
        CustomerService.createCustomer(customer);
         model.addAttribute("allCustomers",CustomerService.getCustomers());
         return "redirect:customer";
    }
}
