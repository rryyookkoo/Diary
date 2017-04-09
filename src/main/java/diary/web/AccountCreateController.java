package diary.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ryoko on 17/04/09.
 */
@Controller
public class AccountCreateController {
    @RequestMapping("/account/create")
    public String accountCreate(){
        return "account_create";
    }
}
