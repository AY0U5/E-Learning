package ma.zs.alc.service.facade.admin.homework;

import java.util.List;
import ma.zs.alc.bean.core.homework.HoweWorkQSTReponse;
import ma.zs.alc.dao.criteria.core.homework.HoweWorkQSTReponseCriteria;
import ma.zs.alc.zynerator.service.IService;



public interface HoweWorkQSTReponseAdminService extends  IService<HoweWorkQSTReponse,HoweWorkQSTReponseCriteria>  {

    List<HoweWorkQSTReponse> findByHomeWorkQuestionId(Long id);
    int deleteByHomeWorkQuestionId(Long id);
    long countByHomeWorkQuestionRef(String ref);




}
