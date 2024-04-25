package  ma.zs.alc.dao.specification.core.freetrial;

import ma.zs.alc.dao.criteria.core.freetrial.FreeTrialStudentEmailTemplateCriteria;
import ma.zs.alc.bean.core.freetrial.FreeTrialStudentEmailTemplate;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class FreeTrialStudentEmailTemplateSpecification extends  AbstractSpecification<FreeTrialStudentEmailTemplateCriteria, FreeTrialStudentEmailTemplate>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("object", criteria.getObject(),criteria.getObjectLike());
        addPredicate("source", criteria.getSource(),criteria.getSourceLike());
    }

    public FreeTrialStudentEmailTemplateSpecification(FreeTrialStudentEmailTemplateCriteria criteria) {
        super(criteria);
    }

    public FreeTrialStudentEmailTemplateSpecification(FreeTrialStudentEmailTemplateCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
