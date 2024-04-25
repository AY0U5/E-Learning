package ma.zs.alc.service.impl.admin.freetrial;


import ma.zs.alc.bean.core.freetrial.FreeTrialTeacherEmailTemplate;
import ma.zs.alc.dao.criteria.core.freetrial.FreeTrialTeacherEmailTemplateCriteria;
import ma.zs.alc.dao.facade.core.freetrial.FreeTrialTeacherEmailTemplateDao;
import ma.zs.alc.dao.specification.core.freetrial.FreeTrialTeacherEmailTemplateSpecification;
import ma.zs.alc.service.facade.admin.freetrial.FreeTrialTeacherEmailTemplateAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class FreeTrialTeacherEmailTemplateAdminServiceImpl extends AbstractServiceImpl<FreeTrialTeacherEmailTemplate, FreeTrialTeacherEmailTemplateCriteria, FreeTrialTeacherEmailTemplateDao> implements FreeTrialTeacherEmailTemplateAdminService {













    public void configure() {
        super.configure(FreeTrialTeacherEmailTemplate.class, FreeTrialTeacherEmailTemplateSpecification.class);
    }



    public FreeTrialTeacherEmailTemplateAdminServiceImpl(FreeTrialTeacherEmailTemplateDao dao) {
        super(dao);
    }

}
