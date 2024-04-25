package  ma.zs.alc.dao.specification.core.inscriptionref;

import ma.zs.alc.dao.criteria.core.inscriptionref.LangueCriteria;
import ma.zs.alc.bean.core.inscriptionref.Langue;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class LangueSpecification extends  AbstractSpecification<LangueCriteria, Langue>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public LangueSpecification(LangueCriteria criteria) {
        super(criteria);
    }

    public LangueSpecification(LangueCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
