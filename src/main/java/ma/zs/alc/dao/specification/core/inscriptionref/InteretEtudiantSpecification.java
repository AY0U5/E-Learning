package  ma.zs.alc.dao.specification.core.inscriptionref;

import ma.zs.alc.dao.criteria.core.inscriptionref.InteretEtudiantCriteria;
import ma.zs.alc.bean.core.inscriptionref.InteretEtudiant;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class InteretEtudiantSpecification extends  AbstractSpecification<InteretEtudiantCriteria, InteretEtudiant>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public InteretEtudiantSpecification(InteretEtudiantCriteria criteria) {
        super(criteria);
    }

    public InteretEtudiantSpecification(InteretEtudiantCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
