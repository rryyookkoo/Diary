package diary.web.model;

/**
 * Created by ryoko on 17/04/07.
 */
public class PasswordChangeForm {
    private String currentPass;
    private String newPass;
    private String newPass2;

    public String getNewPass2() {
        return newPass2;
    }

    public void setNewPass2(String newPass2) {
        this.newPass2 = newPass2;
    }

    public String getCurrentPass() {
        return currentPass;
    }

    public void setCurrentPass(String currentPass) {
        this.currentPass = currentPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

}
