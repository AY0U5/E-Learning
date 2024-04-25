package ma.zs.alc.service.impl.admin.faq;


import ma.zs.alc.bean.core.faq.FaqType;
import ma.zs.alc.dao.criteria.core.faq.FaqTypeCriteria;
import ma.zs.alc.dao.facade.core.faq.FaqTypeDao;
import ma.zs.alc.dao.specification.core.faq.FaqTypeSpecification;
import ma.zs.alc.service.facade.admin.faq.FaqTypeAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class FaqTypeAdminServiceImpl extends AbstractServiceImpl<FaqType, FaqTypeCriteria, FaqTypeDao> implements FaqTypeAdminService {








    public List<FaqType> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(FaqType.class, FaqTypeSpecification.class);
    }



    public FaqTypeAdminServiceImpl(FaqTypeDao dao) {
        super(dao);
    }

}
