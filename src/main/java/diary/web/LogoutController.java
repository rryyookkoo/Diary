package diary.web;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ryoko on 17/04/09.
 */
@Controller
public class LogoutController {
    @RequestMapping("/logout")
    public String logout(){
        SecurityContextHolder.clearContext();
        return "login";
    }
}
