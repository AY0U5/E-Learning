package  ma.zs.alc.dao.specification.core.freetrial;

import ma.zs.alc.dao.criteria.core.freetrial.FreeTrialTeacherWhatsTemplateCriteria;
import ma.zs.alc.bean.core.freetrial.FreeTrialTeacherWhatsTemplate;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class FreeTrialTeacherWhatsTemplateSpecification extends  AbstractSpecification<FreeTrialTeacherWhatsTemplateCriteria, FreeTrialTeacherWhatsTemplate>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("object", criteria.getObject(),criteria.getObjectLike());
        addPredicate("source", criteria.getSource(),criteria.getSourceLike());
    }

    public FreeTrialTeacherWhatsTemplateSpecification(FreeTrialTeacherWhatsTemplateCriteria criteria) {
        super(criteria);
    }

    public FreeTrialTeacherWhatsTemplateSpecification(FreeTrialTeacherWhatsTemplateCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
