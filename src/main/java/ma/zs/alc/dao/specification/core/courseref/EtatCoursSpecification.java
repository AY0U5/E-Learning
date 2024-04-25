package  ma.zs.alc.dao.specification.core.courseref;

import ma.zs.alc.dao.criteria.core.courseref.EtatCoursCriteria;
import ma.zs.alc.bean.core.courseref.EtatCours;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class EtatCoursSpecification extends  AbstractSpecification<EtatCoursCriteria, EtatCours>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public EtatCoursSpecification(EtatCoursCriteria criteria) {
        super(criteria);
    }

    public EtatCoursSpecification(EtatCoursCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
