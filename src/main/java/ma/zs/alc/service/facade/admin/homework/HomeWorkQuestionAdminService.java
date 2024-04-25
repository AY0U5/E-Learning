package ma.zs.alc.service.facade.admin.homework;

import java.util.List;
import ma.zs.alc.bean.core.homework.HomeWorkQuestion;
import ma.zs.alc.dao.criteria.core.homework.HomeWorkQuestionCriteria;
import ma.zs.alc.zynerator.service.IService;



public interface HomeWorkQuestionAdminService extends  IService<HomeWorkQuestion,HomeWorkQuestionCriteria>  {

    List<HomeWorkQuestion> findByTypeDeQuestionId(Long id);
    int deleteByTypeDeQuestionId(Long id);
    long countByTypeDeQuestionRef(String ref);
    List<HomeWorkQuestion> findByHomeWorkId(Long id);
    int deleteByHomeWorkId(Long id);
    long countByHomeWorkId(Long id);




}
