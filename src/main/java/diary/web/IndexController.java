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

//    @RequestMapping(method = RequestMethod.GET)
//    String list(Model model) {
//        List<Customer> customers = customerService.findAll();
//        model.addAttribute("customers", customers);
//        return "customers/list";
//    }

    @RequestMapping("/")
    public String index(Model model){

        List<Diary> publicDiary = indexService.findByIsPublicOrderByCreatedAtDesc(0);
        model.addAttribute("public_diaries", publicDiary);

        List<Diary> userDiary = indexService.findByUserIdOrderByCreatedAtDesc("user01");
        model.addAttribute("user_diaries", userDiary);

        System.out.println("public_diaries = " + publicDiary);
        System.out.println("public_diaries = " + userDiary);

        return "index";
    }
}
