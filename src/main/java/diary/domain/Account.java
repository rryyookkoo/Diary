package diary.domain;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by ryoko on 17/04/02.
 */
@Entity
public class Account extends User {
    @Id
    private String userId;
    private String password;
    private Date createdAt;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Account(){
        this("a","a", new ArrayList<GrantedAuthority>());
    }

    public Account(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, true, true, true, true, authorities);
        this.password = password;
    }

    public Account(String userId, String password, Date createdAt){
        super("super","super",true,true,true,true,new ArrayList<GrantedAuthority>());
        this.userId = userId;
        this.password = password;
        this.createdAt = createdAt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
