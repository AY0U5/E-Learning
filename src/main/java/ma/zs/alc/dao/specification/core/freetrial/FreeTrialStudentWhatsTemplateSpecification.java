package  ma.zs.alc.dao.specification.core.freetrial;

import ma.zs.alc.dao.criteria.core.freetrial.FreeTrialStudentWhatsTemplateCriteria;
import ma.zs.alc.bean.core.freetrial.FreeTrialStudentWhatsTemplate;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class FreeTrialStudentWhatsTemplateSpecification extends  AbstractSpecification<FreeTrialStudentWhatsTemplateCriteria, FreeTrialStudentWhatsTemplate>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("object", criteria.getObject(),criteria.getObjectLike());
        addPredicate("source", criteria.getSource(),criteria.getSourceLike());
    }

    public FreeTrialStudentWhatsTemplateSpecification(FreeTrialStudentWhatsTemplateCriteria criteria) {
        super(criteria);
    }

    public FreeTrialStudentWhatsTemplateSpecification(FreeTrialStudentWhatsTemplateCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
