package diary.web;

import diary.domain.Account;
import diary.repository.AccountRepository;
import diary.service.AccountCreateService;
import diary.web.model.AccountCreateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

/**
 * Created by ryoko on 17/04/09.
 */
@Controller
public class AccountCreateController {
    @Autowired
    AccountCreateService accountCreateService;

    @Autowired
    AccountRepository accountRepository;

    @RequestMapping("/account/create")
    public String accountCreate(@ModelAttribute AccountCreateForm diaryCreateForm, Model model){
        return "account_create";
    }
    @RequestMapping("/account/do_create")
    public String accountDoCreate(@ModelAttribute AccountCreateForm diaryCreateForm, Model model){
        //check
        

        //insert
        String encodedPass = new BCryptPasswordEncoder().encode(diaryCreateForm.getPassword());
        Account account = accountCreateService
                .save(new Account(diaryCreateForm.getUserId(), encodedPass, new Date()));

        List<Account> accounts = accountRepository.findAll();

        System.out.println("encodedPass = " + encodedPass);
        for(Account account2 : accounts){
            System.out.println("userId = " + account2.getUserId());
            System.out.println("password = " + account2.getPassword());
            System.out.println("createdAt = " + account2.getCreatedAt());
        }

        return "login";
    }
}
