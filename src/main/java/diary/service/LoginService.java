package diary.service;

import diary.domain.Account;
import diary.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryoko on 17/04/02.
 */
@Service
public class LoginService implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("roleA"));
        //return new Account("user01","$2a$10$XAVqnVb6TFhgiWgVxJlLy.BF5SdorrEa.mpT3mkVALJ1EarKuaCg2",list);
        Account account = accountRepository.findByUserId(username);

        if(account==null){
            throw new UsernameNotFoundException("UsernameNotFoundException");
        }

        Account account2 = new Account(username,account.getPassword(),list);

        return account2;
    }
}
