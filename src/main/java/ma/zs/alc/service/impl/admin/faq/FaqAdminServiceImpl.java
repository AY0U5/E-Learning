package ma.zs.alc.service.impl.admin.faq;


import ma.zs.alc.bean.core.faq.Faq;
import ma.zs.alc.dao.criteria.core.faq.FaqCriteria;
import ma.zs.alc.dao.facade.core.faq.FaqDao;
import ma.zs.alc.dao.specification.core.faq.FaqSpecification;
import ma.zs.alc.service.facade.admin.faq.FaqAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.alc.service.facade.admin.faq.FaqTypeAdminService ;
import ma.zs.alc.bean.core.faq.FaqType ;

import java.util.List;
@Service
public class FaqAdminServiceImpl extends AbstractServiceImpl<Faq, FaqCriteria, FaqDao> implements FaqAdminService {






    public void findOrSaveAssociatedObject(Faq t){
        if( t != null) {
            t.setFaqType(faqTypeService.findOrSave(t.getFaqType()));
        }
    }

    public List<Faq> findByFaqTypeId(Long id){
        return dao.findByFaqTypeId(id);
    }
    public int deleteByFaqTypeId(Long id){
        return dao.deleteByFaqTypeId(id);
    }
    public long countByFaqTypeId(Long id){
        return dao.countByFaqTypeId(id);
    }

    public List<Faq> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Faq.class, FaqSpecification.class);
    }


    @Autowired
    private FaqTypeAdminService faqTypeService ;

    public FaqAdminServiceImpl(FaqDao dao) {
        super(dao);
    }

}
