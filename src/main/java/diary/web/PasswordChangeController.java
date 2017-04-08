package diary.web;

import diary.domain.Account;
import diary.service.PasswordChangeService;
import diary.web.model.PasswordChangeForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ryoko on 17/04/05.
 */
@Controller
public class PasswordChangeController {
    @Autowired
    PasswordChangeService passwordChangeService;
    @Autowired
    IndexController indexController;


    @RequestMapping("/password/change")
    public String passwordChange(@ModelAttribute PasswordChangeForm passwordChangeForm, Model model){

        return "password_change";
    }

    @RequestMapping("/password/do_change")
    public String passwordDoChange(@ModelAttribute PasswordChangeForm passwordChangeForm, Model model){

        //認証情報の取得
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String userId;
        String password;
        String currentPass;
        boolean error = false;
        String errorMessage = "";

        if (principal instanceof UserDetails) {
            userId = ((UserDetails)principal).getUsername();
            password = ((UserDetails)principal).getPassword();
        } else {
            userId = principal.toString();
            password = principal.toString();
        }

        currentPass = new BCryptPasswordEncoder().encode(passwordChangeForm.getCurrentPass());

        System.out.println("password = " + password);
        System.out.println("currentPass = " + currentPass);
        System.out.println("currentPass = " + passwordChangeForm.getCurrentPass());

        //エラーチェック
        if (new BCryptPasswordEncoder().matches(passwordChangeForm.getCurrentPass(),password)) {
            if (passwordChangeForm.getNewPass().equals(passwordChangeForm.getNewPass2())){
                if (passwordChangeForm.getNewPass().length() >= 8){
                    if (passwordChangeForm.getNewPass().matches("[0-9a-zA-Z-_]+")){
                        //エラーなし
                        Account account = passwordChangeService.findByUserId(userId);
                        account.setPassword(passwordChangeForm.getNewPass());
                        this.passwordChangeService.save(account);
                    } else {
                        //半角英数字、-、_以外の場合エラー
                        error = true;
                        errorMessage = "使用できる文字は、半角英数字、「-」、「_」のみです。";
                    }
                } else {
                    //８文字未満の場合エラー
                    error = true;
                    errorMessage = "新しいパスワードは8文字以上で入力してください。";
                }
            } else {
                //新しいパスワード、新しいパスワード（確認）が一致しない場合エラー
                error = true;
                errorMessage = "新しいパスワード、新しいパスワード（確認）が一致しません。";
            }
        } else {
            //現在のパスワードが一致しない場合エラー
            error = true;
            errorMessage = "現在のパスワードが登録されたパスワードと一致しません。";
        }

        model.addAttribute("error", error);
        model.addAttribute("PasswordChangeForm", new PasswordChangeForm());

        //遷移先判定
        if(error){
            //エラーがある場合、パスワード変更画面へ遷移
            model.addAttribute("error_message", errorMessage);
            return "password_change";
        }else{
            //エラーがない場合、トップページへ遷移
            indexController.index(model);
            return "index";
        }
    }
}
