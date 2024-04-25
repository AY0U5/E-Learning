package ma.zs.alc.service.facade.admin.quiz;

import java.util.List;
import ma.zs.alc.bean.core.quiz.QuizClassRoom;
import ma.zs.alc.dao.criteria.core.quiz.QuizClassRoomCriteria;
import ma.zs.alc.zynerator.service.IService;



public interface QuizClassRoomAdminService extends  IService<QuizClassRoom,QuizClassRoomCriteria>  {

    List<QuizClassRoom> findByClassRoomId(Long id);
    int deleteByClassRoomId(Long id);
    long countByClassRoomId(Long id);
    List<QuizClassRoom> findByQuizId(Long id);
    int deleteByQuizId(Long id);
    long countByQuizRef(String ref);




}
