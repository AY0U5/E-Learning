package  ma.zs.alc.dao.specification.core.inscriptionref;

import ma.zs.alc.dao.criteria.core.inscriptionref.TeacherLocalityCriteria;
import ma.zs.alc.bean.core.inscriptionref.TeacherLocality;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class TeacherLocalitySpecification extends  AbstractSpecification<TeacherLocalityCriteria, TeacherLocality>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public TeacherLocalitySpecification(TeacherLocalityCriteria criteria) {
        super(criteria);
    }

    public TeacherLocalitySpecification(TeacherLocalityCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
