package ma.zs.alc.service.facade.admin.prof;

import java.util.List;
import ma.zs.alc.bean.core.prof.Prof;
import ma.zs.alc.dao.criteria.core.prof.ProfCriteria;
import ma.zs.alc.zynerator.service.IService;



public interface ProfAdminService extends  IService<Prof,ProfCriteria>  {
    Prof findByUsername(String username);
    boolean changePassword(String username, String newPassword);

    List<Prof> findByParcoursId(Long id);
    int deleteByParcoursId(Long id);
    long countByParcoursCode(String code);
    List<Prof> findByCategorieProfId(Long id);
    int deleteByCategorieProfId(Long id);
    long countByCategorieProfCode(String code);
    List<Prof> findByTypeTeacherId(Long id);
    int deleteByTypeTeacherId(Long id);
    long countByTypeTeacherCode(String code);




}
