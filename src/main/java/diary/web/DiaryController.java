package diary.web;

import diary.domain.Diary;
import diary.repository.DiaryRepository;
import diary.web.model.DiaryCreateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by ryoko on 17/04/04.
 */
@Controller
public class DiaryController {
    @Autowired
    DiaryRepository diaryRepository;

    @RequestMapping("/diary/create")
    public String diaryCreate(@ModelAttribute DiaryCreateForm diaryCreateForm, Model model){
        return "diary_create";
    }

    @Autowired
    IndexController indexController;

    @RequestMapping("/diary/do_create")
    public String diaryDoCreate(@ModelAttribute DiaryCreateForm diaryCreateForm, Model model){

        //認証情報の取得
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String userId;

        if (principal instanceof UserDetails) {
            userId = ((UserDetails)principal).getUsername();
        } else {
            userId = principal.toString();
        }

        //現在日時の取得
        Date date =new Date();

        //isPublicの値の取得
        boolean isPublic;
        if(diaryCreateForm.getIsPublic().equals("1")) {
            isPublic = true;
        } else {
            isPublic = false;
        }

        Diary diary = this.diaryRepository
                .save(new Diary(diaryCreateForm.getTitle(), diaryCreateForm.getContent(), isPublic, userId, date));

        model.addAttribute("DiaryCreateForm", new DiaryCreateForm());

        indexController.index(model);

        return "index";
    }

}
