package ma.zs.alc.service.facade.admin.faq;

import java.util.List;
import ma.zs.alc.bean.core.faq.FaqProf;
import ma.zs.alc.dao.criteria.core.faq.FaqProfCriteria;
import ma.zs.alc.zynerator.service.IService;



public interface FaqProfAdminService extends  IService<FaqProf,FaqProfCriteria>  {

    List<FaqProf> findByProfId(Long id);
    int deleteByProfId(Long id);
    long countByProfRef(String ref);
    List<FaqProf> findByAdminId(Long id);
    int deleteByAdminId(Long id);
    long countByAdminId(Long id);
    List<FaqProf> findByFaqTypeId(Long id);
    int deleteByFaqTypeId(Long id);
    long countByFaqTypeId(Long id);




}
