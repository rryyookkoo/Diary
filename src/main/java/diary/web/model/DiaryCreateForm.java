package diary.web.model;

/**
 * Created by ryoko on 17/04/05.
 */
public class DiaryCreateForm {
    private String title;
    private String content;
    private String isPublic = "1";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(String isPublic) {
        this.isPublic = isPublic;
    }
}
