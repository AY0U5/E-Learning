package  ma.zs.alc.dao.specification.core.homework;

import ma.zs.alc.dao.criteria.core.homework.TypeHomeWorkCriteria;
import ma.zs.alc.bean.core.homework.TypeHomeWork;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class TypeHomeWorkSpecification extends  AbstractSpecification<TypeHomeWorkCriteria, TypeHomeWork>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("lib", criteria.getLib(),criteria.getLibLike());
    }

    public TypeHomeWorkSpecification(TypeHomeWorkCriteria criteria) {
        super(criteria);
    }

    public TypeHomeWorkSpecification(TypeHomeWorkCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
