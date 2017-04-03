package diary.service;

import diary.domain.Diary;
import diary.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ryoko on 17/04/03.
 */
@Service
public class IndexService {
    @Autowired
    private DiaryRepository diaryRepository;

    public List<Diary> findByIsPublicOrderByCreatedAtDesc(Integer isPublic){
        return diaryRepository.findByIsPublicOrderByCreatedAtDesc(isPublic);
    }

    public List<Diary> findByUserIdOrderByCreatedAtDesc(String userId){
        return diaryRepository.findByUserIdOrderByCreatedAtDesc(userId);
    }


}
