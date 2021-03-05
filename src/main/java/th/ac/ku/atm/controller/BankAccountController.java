package th.ac.ku.atm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.atm.model.BankAccount;
import th.ac.ku.atm.service.BankAccountService;
import th.ac.ku.atm.service.BankAccountServiceApi;

@Controller
@RequestMapping("/bankaccount")
public class BankAccountController {

    @Autowired
    private BankAccountServiceApi bankAccountServiceApi;

    public  BankAccountController(BankAccountServiceApi bankAccountService)
    {
        this.bankAccountServiceApi = bankAccountService;
    }

    @GetMapping
    public String getBankAccountPage(Model model) {
        model.addAttribute("bankaccounts", bankAccountServiceApi.getBankAccounts());
        return "bankaccount";
    }

    @PostMapping
    public String openAccount(@ModelAttribute BankAccount account, Model model) {
        bankAccountServiceApi.openAccount(account);
        model.addAttribute("bankaccounts",bankAccountServiceApi.getBankAccounts());
        return "redirect:bankaccount";
    }




}
