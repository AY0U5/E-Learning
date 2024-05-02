package  ma.zs.alc.dao.specification.core.courseref;

import ma.zs.alc.dao.criteria.core.courseref.EtatSectionCriteria;
import ma.zs.alc.bean.core.courseref.EtatSection;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class EtatSectionSpecification extends  AbstractSpecification<EtatSectionCriteria, EtatSection>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public EtatSectionSpecification(EtatSectionCriteria criteria) {
        super(criteria);
    }

    public EtatSectionSpecification(EtatSectionCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
