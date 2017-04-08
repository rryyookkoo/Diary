package diary.service;

import diary.domain.Account;
import diary.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ryoko on 17/04/08.
 */
@Service
public class PasswordChangeService {
    @Autowired
    AccountRepository accountRepository;

    public Account findByUserId(String userId){
        return accountRepository.findByUserId(userId);
    }

    public Account save(Account account) {
        return accountRepository.save(account);
    }
}
