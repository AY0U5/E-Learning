package ma.zs.alc.service.impl.admin.homework;


import ma.zs.alc.bean.core.homework.ReponseEtudiantHomeWork;
import ma.zs.alc.dao.criteria.core.homework.ReponseEtudiantHomeWorkCriteria;
import ma.zs.alc.dao.facade.core.homework.ReponseEtudiantHomeWorkDao;
import ma.zs.alc.dao.specification.core.homework.ReponseEtudiantHomeWorkSpecification;
import ma.zs.alc.service.facade.admin.homework.ReponseEtudiantHomeWorkAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.alc.service.facade.admin.homework.HoweWorkQSTReponseAdminService ;
import ma.zs.alc.bean.core.homework.HoweWorkQSTReponse ;
import ma.zs.alc.service.facade.admin.homework.HomeWorkEtudiantAdminService ;
import ma.zs.alc.bean.core.homework.HomeWorkEtudiant ;
import ma.zs.alc.service.facade.admin.homework.HomeWorkQuestionAdminService ;
import ma.zs.alc.bean.core.homework.HomeWorkQuestion ;

import java.util.List;
@Service
public class ReponseEtudiantHomeWorkAdminServiceImpl extends AbstractServiceImpl<ReponseEtudiantHomeWork, ReponseEtudiantHomeWorkCriteria, ReponseEtudiantHomeWorkDao> implements ReponseEtudiantHomeWorkAdminService {






    public void findOrSaveAssociatedObject(ReponseEtudiantHomeWork t){
        if( t != null) {
            t.setHoweWorkQSTReponse(howeWorkQSTReponseService.findOrSave(t.getHoweWorkQSTReponse()));
            t.setHomeWorkEtudiant(homeWorkEtudiantService.findOrSave(t.getHomeWorkEtudiant()));
            t.setHomeWorkQuestion(homeWorkQuestionService.findOrSave(t.getHomeWorkQuestion()));
        }
    }

    public List<ReponseEtudiantHomeWork> findByHoweWorkQSTReponseId(Long id){
        return dao.findByHoweWorkQSTReponseId(id);
    }
    public int deleteByHoweWorkQSTReponseId(Long id){
        return dao.deleteByHoweWorkQSTReponseId(id);
    }
    public long countByHoweWorkQSTReponseRef(String ref){
        return dao.countByHoweWorkQSTReponseRef(ref);
    }
    public List<ReponseEtudiantHomeWork> findByHomeWorkEtudiantId(Long id){
        return dao.findByHomeWorkEtudiantId(id);
    }
    public int deleteByHomeWorkEtudiantId(Long id){
        return dao.deleteByHomeWorkEtudiantId(id);
    }
    public long countByHomeWorkEtudiantId(Long id){
        return dao.countByHomeWorkEtudiantId(id);
    }
    public List<ReponseEtudiantHomeWork> findByHomeWorkQuestionId(Long id){
        return dao.findByHomeWorkQuestionId(id);
    }
    public int deleteByHomeWorkQuestionId(Long id){
        return dao.deleteByHomeWorkQuestionId(id);
    }
    public long countByHomeWorkQuestionRef(String ref){
        return dao.countByHomeWorkQuestionRef(ref);
    }






    public void configure() {
        super.configure(ReponseEtudiantHomeWork.class, ReponseEtudiantHomeWorkSpecification.class);
    }


    @Autowired
    private HoweWorkQSTReponseAdminService howeWorkQSTReponseService ;
    @Autowired
    private HomeWorkEtudiantAdminService homeWorkEtudiantService ;
    @Autowired
    private HomeWorkQuestionAdminService homeWorkQuestionService ;

    public ReponseEtudiantHomeWorkAdminServiceImpl(ReponseEtudiantHomeWorkDao dao) {
        super(dao);
    }

}
