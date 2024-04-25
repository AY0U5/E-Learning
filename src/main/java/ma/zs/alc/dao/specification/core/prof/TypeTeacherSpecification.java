package  ma.zs.alc.dao.specification.core.prof;

import ma.zs.alc.dao.criteria.core.prof.TypeTeacherCriteria;
import ma.zs.alc.bean.core.prof.TypeTeacher;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class TypeTeacherSpecification extends  AbstractSpecification<TypeTeacherCriteria, TypeTeacher>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public TypeTeacherSpecification(TypeTeacherCriteria criteria) {
        super(criteria);
    }

    public TypeTeacherSpecification(TypeTeacherCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
