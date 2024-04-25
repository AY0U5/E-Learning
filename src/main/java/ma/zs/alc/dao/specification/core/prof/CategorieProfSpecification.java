package  ma.zs.alc.dao.specification.core.prof;

import ma.zs.alc.dao.criteria.core.prof.CategorieProfCriteria;
import ma.zs.alc.bean.core.prof.CategorieProf;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class CategorieProfSpecification extends  AbstractSpecification<CategorieProfCriteria, CategorieProf>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("level", criteria.getLevel(),criteria.getLevelLike());
        addPredicateBigDecimal("lessonRate", criteria.getLessonRate(), criteria.getLessonRateMin(), criteria.getLessonRateMax());
    }

    public CategorieProfSpecification(CategorieProfCriteria criteria) {
        super(criteria);
    }

    public CategorieProfSpecification(CategorieProfCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
