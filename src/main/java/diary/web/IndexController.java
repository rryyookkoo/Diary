package diary.web;

import diary.domain.Diary;
import diary.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by ryoko on 17/04/02.
 */
@Controller
public class IndexController {
    @Autowired
    IndexService indexService;

    @RequestMapping("/")
    public String index(Model model){

        //認証情報の取得
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String userId;

        if (principal instanceof UserDetails) {
            userId = ((UserDetails)principal).getUsername();
        } else {
            userId = principal.toString();
        }

        model.addAttribute("userId", userId);

        //新着の日記一覧の取得
        List<Diary> publicDiary = indexService.findByIsPublicOrderByCreatedAtDesc(true);

        for (int i = 9 ; i < publicDiary.size() ; i++){
            publicDiary.remove(i);
        }

        model.addAttribute("public_diaries", publicDiary);

        //ログインユーザの日記一覧を取得
        List<Diary> userDiary = indexService.findByUserIdOrderByCreatedAtDesc(userId);
        model.addAttribute("user_diaries", userDiary);

        return "index";
    }
}
