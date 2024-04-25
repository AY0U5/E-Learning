package  ma.zs.alc.dao.specification.core.prof;

import ma.zs.alc.dao.criteria.core.prof.CalendrierProfCriteria;
import ma.zs.alc.bean.core.prof.CalendrierProf;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class CalendrierProfSpecification extends  AbstractSpecification<CalendrierProfCriteria, CalendrierProf>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("startTime", criteria.getStartTime(),criteria.getStartTimeLike());
        addPredicate("endTime", criteria.getEndTime(),criteria.getEndTimeLike());
        addPredicate("startRecur", criteria.getStartRecur(), criteria.getStartRecurFrom(), criteria.getStartRecurTo());
        addPredicate("endRecur", criteria.getEndRecur(), criteria.getEndRecurFrom(), criteria.getEndRecurTo());
        addPredicateFk("prof","id", criteria.getProf()==null?null:criteria.getProf().getId());
        addPredicateFk("prof","id", criteria.getProfs());
        addPredicateFk("prof","ref", criteria.getProf()==null?null:criteria.getProf().getRef());
        addPredicateFk("etudiant","id", criteria.getEtudiant()==null?null:criteria.getEtudiant().getId());
        addPredicateFk("etudiant","id", criteria.getEtudiants());
        addPredicateFk("etudiant","ref", criteria.getEtudiant()==null?null:criteria.getEtudiant().getRef());
    }

    public CalendrierProfSpecification(CalendrierProfCriteria criteria) {
        super(criteria);
    }

    public CalendrierProfSpecification(CalendrierProfCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
