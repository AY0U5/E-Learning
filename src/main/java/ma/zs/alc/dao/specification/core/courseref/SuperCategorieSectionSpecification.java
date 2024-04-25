package  ma.zs.alc.dao.specification.core.courseref;

import ma.zs.alc.dao.criteria.core.courseref.SuperCategorieSectionCriteria;
import ma.zs.alc.bean.core.courseref.SuperCategorieSection;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class SuperCategorieSectionSpecification extends  AbstractSpecification<SuperCategorieSectionCriteria, SuperCategorieSection>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public SuperCategorieSectionSpecification(SuperCategorieSectionCriteria criteria) {
        super(criteria);
    }

    public SuperCategorieSectionSpecification(SuperCategorieSectionCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
