package  ma.zs.alc.dao.specification.core.recomrecla;

import ma.zs.alc.dao.criteria.core.recomrecla.TypeReclamationProfCriteria;
import ma.zs.alc.bean.core.recomrecla.TypeReclamationProf;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class TypeReclamationProfSpecification extends  AbstractSpecification<TypeReclamationProfCriteria, TypeReclamationProf>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public TypeReclamationProfSpecification(TypeReclamationProfCriteria criteria) {
        super(criteria);
    }

    public TypeReclamationProfSpecification(TypeReclamationProfCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
