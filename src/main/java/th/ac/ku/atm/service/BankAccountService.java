package th.ac.ku.atm.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import th.ac.ku.atm.model.BankAccount;
import th.ac.ku.atm.model.Customer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BankAccountService {

    private List<BankAccount>  bankAccountsList;
    private customerService CustomerService;
    @PostConstruct
    public void postConstruct() {
        this.bankAccountsList = new ArrayList<>();
    }
    public BankAccountService(customerService CustomerService) {
        this.CustomerService = CustomerService;
    }

    public void createBankAccount(BankAccount bankAccount) {
        Customer storedCustomer = CustomerService.findCustomer(bankAccount.getCustomerId());
        if (storedCustomer != null) {
            bankAccountsList.add(bankAccount);
        }
    }

    public List<BankAccount> getCustomers() {

        return new ArrayList<>(this.bankAccountsList);
    }

    public boolean removebankAccount(int id) {
        for (BankAccount bankAccount : bankAccountsList) {
            if (bankAccount.getId() == id)
            {
               bankAccountsList.remove(bankAccount);
               return true;
            }
        }
        return false;
    }
}
