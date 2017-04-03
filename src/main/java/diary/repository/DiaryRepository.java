package diary.repository;

import diary.domain.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by ryoko on 17/04/03.
 */
public interface DiaryRepository extends JpaRepository<Diary, Integer> {
    Diary findById(Integer id);

    List<Diary> findByIsPublicOrderByCreatedAtDesc(boolean isPublic);

    List<Diary> findByUserIdOrderByCreatedAtDesc(String userId);
}
