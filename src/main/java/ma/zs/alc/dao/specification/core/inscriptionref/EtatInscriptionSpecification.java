package  ma.zs.alc.dao.specification.core.inscriptionref;

import ma.zs.alc.dao.criteria.core.inscriptionref.EtatInscriptionCriteria;
import ma.zs.alc.bean.core.inscriptionref.EtatInscription;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class EtatInscriptionSpecification extends  AbstractSpecification<EtatInscriptionCriteria, EtatInscription>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public EtatInscriptionSpecification(EtatInscriptionCriteria criteria) {
        super(criteria);
    }

    public EtatInscriptionSpecification(EtatInscriptionCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
