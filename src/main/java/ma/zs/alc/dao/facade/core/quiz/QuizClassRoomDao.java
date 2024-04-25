package ma.zs.alc.dao.facade.core.quiz;

import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.quiz.QuizClassRoom;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface QuizClassRoomDao extends AbstractRepository<QuizClassRoom,Long>  {

    List<QuizClassRoom> findByClassRoomId(Long id);
    int deleteByClassRoomId(Long id);
    long countByClassRoomId(Long id);
    List<QuizClassRoom> findByQuizId(Long id);
    int deleteByQuizId(Long id);
    long countByQuizRef(String ref);


}
