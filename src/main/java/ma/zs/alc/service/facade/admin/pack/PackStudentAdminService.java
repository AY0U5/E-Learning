package ma.zs.alc.service.facade.admin.pack;

import java.util.List;
import ma.zs.alc.bean.core.pack.PackStudent;
import ma.zs.alc.dao.criteria.core.pack.PackStudentCriteria;
import ma.zs.alc.zynerator.service.IService;



public interface PackStudentAdminService extends  IService<PackStudent,PackStudentCriteria>  {

    List<PackStudent> findByParcoursId(Long id);
    int deleteByParcoursId(Long id);
    long countByParcoursCode(String code);
    List<PackStudent> findByPriceId(Long id);
    int deleteByPriceId(Long id);
    long countByPriceId(Long id);




}
