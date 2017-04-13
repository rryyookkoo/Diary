package diary.domain;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ryoko on 17/04/03.
 */
@Entity
public class Diary {
    @Id
    @GeneratedValue
    private int id;
    private boolean isPublic;
    private Date createdAt;
    private String userId;
    private String title;
    private String content;

    public Diary() {
    }

    public Diary(int id, String title, String content, boolean isPublic,String userId, Date createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.isPublic = isPublic;
        this.userId = userId;
        this.createdAt = createdAt;
    }

    public Diary(String title, String content, boolean isPublic,String userId, Date createdAt) {
        this.title = title;
        this.content = content;
        this.isPublic = isPublic;
        this.userId = userId;
        this.createdAt = createdAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

}
