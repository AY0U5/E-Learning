package  ma.zs.alc.dao.specification.core.inscriptionref;

import ma.zs.alc.dao.criteria.core.inscriptionref.NiveauEtudeCriteria;
import ma.zs.alc.bean.core.inscriptionref.NiveauEtude;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class NiveauEtudeSpecification extends  AbstractSpecification<NiveauEtudeCriteria, NiveauEtude>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public NiveauEtudeSpecification(NiveauEtudeCriteria criteria) {
        super(criteria);
    }

    public NiveauEtudeSpecification(NiveauEtudeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
