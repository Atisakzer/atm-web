package th.ac.ku.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.ku.atm.model.BankAccount;
import th.ac.ku.atm.service.BankAccountService;

@Controller
@RequestMapping("/bankAccount")
public class BankAccountController {

    private BankAccountService bankAccountService;

    public  BankAccountController(BankAccountService bankAccountService)
    {
        this.bankAccountService = bankAccountService;
    }
    @RequestMapping
    public  String getbankAccountPage(Model model)
    {
        model.addAttribute("allBank", bankAccountService.getCustomers());
        return  "bankAccount";
    }

    @PostMapping
    public  String addbankAccount(@ModelAttribute BankAccount bankAccount, Model model){
        bankAccountService.createBankAccount(bankAccount);
        model.addAttribute("allBank",bankAccountService.getCustomers());
        return "redirect:bankAccount";
    }

}
