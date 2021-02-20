package th.ac.ku.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.ku.atm.model.Customer;
import th.ac.ku.atm.service.customerService;

@Controller
@RequestMapping("/login")
public class LoginController {
    private customerService CustomerService;

    public LoginController(customerService customerService) {
        this.CustomerService = customerService;
    }

    @GetMapping
    public String getLoginPage() {
        return "login";   // return login.html
    }

    @PostMapping
    public String login(@ModelAttribute Customer customer, Model model) {

        Customer matchingCustomer = CustomerService.checkPin(customer);

        if (matchingCustomer != null) {
            model.addAttribute("greeting",
                    "Welcome, " + matchingCustomer.getName());
        } else {

            model.addAttribute("greeting", "Can't find customer");
        }
        return "home";
    }

}
