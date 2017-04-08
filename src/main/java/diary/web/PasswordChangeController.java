package diary.web;

import diary.web.model.PasswordChangeForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ryoko on 17/04/05.
 */
@Controller
public class PasswordChangeController {

    @RequestMapping("/password/change")
    public String passwordChange(@ModelAttribute PasswordChangeForm passwordChangeForm, Model model){

        return "password_change";
    }
}
