package diary.service;

import diary.domain.Account;
import diary.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ryoko on 17/04/11.
 */
@Service
public class AccountCreateService {
    @Autowired
    AccountRepository accountRepository;

    public Account save(Account account){
        return accountRepository.save(account);
    }

    public Account findByUserId(String userId){
        return accountRepository.findByUserId(userId);
    }
}
