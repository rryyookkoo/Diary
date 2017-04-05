package diary.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ryoko on 17/04/04.
 */
@Controller
public class DiaryController {
    @RequestMapping("/diary/create")
    public String diaryCreate(){
        return "diary_create";
    }

    @Autowired
    IndexController indexController;

    @RequestMapping("/diary/do_create")
    public String diaryDoCreate(Model model){
        indexController.index(model);
        return "index";
    }

}
