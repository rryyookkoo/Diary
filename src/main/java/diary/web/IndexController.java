package diary.web;

import diary.domain.Diary;
import diary.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
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

        List<Diary> publicDiary = indexService.findByIsPublicOrderByCreatedAtDesc(true);
        model.addAttribute("public_diaries", publicDiary);

        List<Diary> userDiary = indexService.findByUserIdOrderByCreatedAtDesc("user01");
        model.addAttribute("user_diaries", userDiary);

        return "index";
    }
}
