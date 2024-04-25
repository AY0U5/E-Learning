package ma.zs.alc.service.impl.admin.freetrial;


import ma.zs.alc.bean.core.freetrial.FreeTrialStudentEmailTemplate;
import ma.zs.alc.dao.criteria.core.freetrial.FreeTrialStudentEmailTemplateCriteria;
import ma.zs.alc.dao.facade.core.freetrial.FreeTrialStudentEmailTemplateDao;
import ma.zs.alc.dao.specification.core.freetrial.FreeTrialStudentEmailTemplateSpecification;
import ma.zs.alc.service.facade.admin.freetrial.FreeTrialStudentEmailTemplateAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class FreeTrialStudentEmailTemplateAdminServiceImpl extends AbstractServiceImpl<FreeTrialStudentEmailTemplate, FreeTrialStudentEmailTemplateCriteria, FreeTrialStudentEmailTemplateDao> implements FreeTrialStudentEmailTemplateAdminService {













    public void configure() {
        super.configure(FreeTrialStudentEmailTemplate.class, FreeTrialStudentEmailTemplateSpecification.class);
    }



    public FreeTrialStudentEmailTemplateAdminServiceImpl(FreeTrialStudentEmailTemplateDao dao) {
        super(dao);
    }

}
