package ma.zs.alc.service.impl.admin.faq;


import ma.zs.alc.bean.core.faq.FaqProf;
import ma.zs.alc.dao.criteria.core.faq.FaqProfCriteria;
import ma.zs.alc.dao.facade.core.faq.FaqProfDao;
import ma.zs.alc.dao.specification.core.faq.FaqProfSpecification;
import ma.zs.alc.service.facade.admin.faq.FaqProfAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.alc.service.facade.admin.faq.FaqTypeAdminService ;
import ma.zs.alc.bean.core.faq.FaqType ;
import ma.zs.alc.service.facade.admin.alc.AdminAdminService ;
import ma.zs.alc.bean.core.alc.Admin ;
import ma.zs.alc.service.facade.admin.prof.ProfAdminService ;
import ma.zs.alc.bean.core.prof.Prof ;

import java.util.List;
@Service
public class FaqProfAdminServiceImpl extends AbstractServiceImpl<FaqProf, FaqProfCriteria, FaqProfDao> implements FaqProfAdminService {






    public void findOrSaveAssociatedObject(FaqProf t){
        if( t != null) {
            t.setProf(profService.findOrSave(t.getProf()));
            t.setAdmin(adminService.findOrSave(t.getAdmin()));
            t.setFaqType(faqTypeService.findOrSave(t.getFaqType()));
        }
    }

    public List<FaqProf> findByProfId(Long id){
        return dao.findByProfId(id);
    }
    public int deleteByProfId(Long id){
        return dao.deleteByProfId(id);
    }
    public long countByProfRef(String ref){
        return dao.countByProfRef(ref);
    }
    public List<FaqProf> findByAdminId(Long id){
        return dao.findByAdminId(id);
    }
    public int deleteByAdminId(Long id){
        return dao.deleteByAdminId(id);
    }
    public long countByAdminId(Long id){
        return dao.countByAdminId(id);
    }
    public List<FaqProf> findByFaqTypeId(Long id){
        return dao.findByFaqTypeId(id);
    }
    public int deleteByFaqTypeId(Long id){
        return dao.deleteByFaqTypeId(id);
    }
    public long countByFaqTypeId(Long id){
        return dao.countByFaqTypeId(id);
    }

    public List<FaqProf> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(FaqProf.class, FaqProfSpecification.class);
    }


    @Autowired
    private FaqTypeAdminService faqTypeService ;
    @Autowired
    private AdminAdminService adminService ;
    @Autowired
    private ProfAdminService profService ;

    public FaqProfAdminServiceImpl(FaqProfDao dao) {
        super(dao);
    }

}
