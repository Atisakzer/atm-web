package th.ac.ku.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.ku.atm.model.Customer;
import th.ac.ku.atm.service.BankAccountServiceApi;
import th.ac.ku.atm.service.customerService;

@Controller
@RequestMapping("/login")
public class LoginController {
    private customerService CustomerService;
    private BankAccountServiceApi bankAccountServiceapi;

    public LoginController(customerService customerService
                           ,BankAccountServiceApi bankAccountServiceApi) {
        this.CustomerService = customerService;
        this.bankAccountServiceapi = bankAccountServiceApi;
    }

    @GetMapping
    public String getLoginPage() {
        return "login";   // return login.html
    }

    @PostMapping
    public String login(@ModelAttribute Customer customer, Model model) {

        Customer matchingCustomer = CustomerService.checkPin(customer);

        if (matchingCustomer != null) {
            model.addAttribute("customertitle",
                    matchingCustomer.getName()+" Bank Accounts");
            model.addAttribute("bankaccounts",bankAccountServiceapi.getCustomerBankAccount(matchingCustomer.getId()));
            return "customeraccount";
        } else {

            model.addAttribute("greeting", "Can't find customer");
        }
        return "home";
    }

}
