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

import java.util.ArrayList;
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
        List<String> errorMessages = new ArrayList<>();

        //ユーザIDが登録済みの場合はエラー
        Account account = accountCreateService.findByUserId(diaryCreateForm.getUserId());
        if(account != null) {
            errorMessages.add("すでに使用されているユーザIDです。");
        }

        //パスワードが8文字未満の場合はエラー
        if(diaryCreateForm.getPassword().length() < 8){
            errorMessages.add("パスワードは8文字以上で設定してください。");
        }

        //パスワード、パスワード（確認）が一致しない場合エラー
        if(!diaryCreateForm.getPassword().equals(diaryCreateForm.getPassword2())){
            errorMessages.add("パスワードとパスワード（確認）が一致しません。");
        }

        //半角英数字、-、_以外の場合エラー
        if (!diaryCreateForm.getPassword().matches("[0-9a-zA-Z-_]+")){
            errorMessages.add("使用できる文字は、半角英数字、「-」、「_」のみです。");
        }

        if(errorMessages.size() > 0 ){
            model.addAttribute("error_messages", errorMessages);
            return "account_create";
        }else {
            //insert
            String encodedPass = new BCryptPasswordEncoder().encode(diaryCreateForm.getPassword());
            Account a = accountCreateService
                    .save(new Account(diaryCreateForm.getUserId(), encodedPass, new Date()));

            model.addAttribute("account", true);
            return "login";
        }
    }
}
