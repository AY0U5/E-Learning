package  ma.zs.alc.dao.specification.core.freetrial;

import ma.zs.alc.dao.criteria.core.freetrial.FreeTrialformuleCriteria;
import ma.zs.alc.bean.core.freetrial.FreeTrialformule;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class FreeTrialformuleSpecification extends  AbstractSpecification<FreeTrialformuleCriteria, FreeTrialformule>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("dayspeerweek", criteria.getDayspeerweek(),criteria.getDayspeerweekLike());
        addPredicate("timeperday", criteria.getTimeperday(),criteria.getTimeperdayLike());
        addPredicate("teacherGenderoption", criteria.getTeacherGenderoption(),criteria.getTeacherGenderoptionLike());
        addPredicate("teacherAgeRange", criteria.getTeacherAgeRange(),criteria.getTeacherAgeRangeLike());
        addPredicate("teacherPersonnality", criteria.getTeacherPersonnality(),criteria.getTeacherPersonnalityLike());
        addPredicateBool("status", criteria.getStatus());
        addPredicate("dateConfirmation", criteria.getDateConfirmation(), criteria.getDateConfirmationFrom(), criteria.getDateConfirmationTo());
        addPredicateFk("inscription","id", criteria.getInscription()==null?null:criteria.getInscription().getId());
        addPredicateFk("inscription","id", criteria.getInscriptions());
    }

    public FreeTrialformuleSpecification(FreeTrialformuleCriteria criteria) {
        super(criteria);
    }

    public FreeTrialformuleSpecification(FreeTrialformuleCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
