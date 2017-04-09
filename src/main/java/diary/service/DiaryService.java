package diary.service;

import diary.domain.Diary;
import diary.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ryoko on 17/04/05.
 */
@Service
public class DiaryService {
    @Autowired
    DiaryRepository diaryRepository;

    public Diary save(Diary diary){
        return diaryRepository.save(diary);
    }

}
