package  ma.zs.alc.dao.specification.core.inscriptionref;

import ma.zs.alc.dao.criteria.core.inscriptionref.FonctionCriteria;
import ma.zs.alc.bean.core.inscriptionref.Fonction;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class FonctionSpecification extends  AbstractSpecification<FonctionCriteria, Fonction>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public FonctionSpecification(FonctionCriteria criteria) {
        super(criteria);
    }

    public FonctionSpecification(FonctionCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
