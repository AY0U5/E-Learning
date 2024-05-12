package ma.zs.alc.service.facade.admin.course;

import java.util.List;
import ma.zs.alc.bean.core.course.Cours;
import ma.zs.alc.dao.criteria.core.course.CoursCriteria;
import ma.zs.alc.zynerator.service.IService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public interface CoursAdminService extends  IService<Cours,CoursCriteria>  {


//    Cours saveCours(Cours cours);

    //
    boolean deleteCourById(Long id);

    List<Cours> findByParcoursCode(String code);

    int deleteByParcoursCode(String code);

    Cours findByCode(String code);

    int deleteByCode(String code);

    Cours saveCours(Cours cours);

    void updateCours(Cours cours);

    List<Cours> findByEtatCoursId(Long id);
    int deleteByEtatCoursId(Long id);
    long countByEtatCoursCode(String code);
    List<Cours> findByParcoursId(Long id);
    int deleteByParcoursId(Long id);
    long countByParcoursCode(String code);




}
