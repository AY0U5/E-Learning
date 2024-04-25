package ma.zs.alc.service.facade.admin.quiz;

import java.util.List;
import ma.zs.alc.bean.core.quiz.Quiz;
import ma.zs.alc.dao.criteria.core.quiz.QuizCriteria;
import ma.zs.alc.zynerator.service.IService;



public interface QuizAdminService extends  IService<Quiz,QuizCriteria>  {

    List<Quiz> findBySectionId(Long id);
    int deleteBySectionId(Long id);
    long countBySectionCode(String code);




}
