package diary.repository;

import diary.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ryoko on 17/04/02.
 */
public interface AccountRepository extends JpaRepository<Account, String> {
    Account findByUserId(String userId);
}
