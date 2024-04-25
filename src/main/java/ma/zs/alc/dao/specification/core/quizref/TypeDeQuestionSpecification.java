package  ma.zs.alc.dao.specification.core.quizref;

import ma.zs.alc.dao.criteria.core.quizref.TypeDeQuestionCriteria;
import ma.zs.alc.bean.core.quizref.TypeDeQuestion;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class TypeDeQuestionSpecification extends  AbstractSpecification<TypeDeQuestionCriteria, TypeDeQuestion>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("lib", criteria.getLib(),criteria.getLibLike());
    }

    public TypeDeQuestionSpecification(TypeDeQuestionCriteria criteria) {
        super(criteria);
    }

    public TypeDeQuestionSpecification(TypeDeQuestionCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
