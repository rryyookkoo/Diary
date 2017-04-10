package diary.web;

import diary.web.model.AccountCreateForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ryoko on 17/04/09.
 */
@Controller
public class AccountCreateController {
    @RequestMapping("/account/create")
    public String accountCreate(@ModelAttribute AccountCreateForm diaryCreateForm, Model model){
        return "account_create";
    }
    @RequestMapping("/account/do_create")
    public String accountDoCreate(@ModelAttribute AccountCreateForm diaryCreateForm, Model model){
        return "login";
    }
}
