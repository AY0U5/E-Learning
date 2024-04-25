package  ma.zs.alc.dao.specification.core.courseref;

import ma.zs.alc.dao.criteria.core.courseref.CategorieSectionCriteria;
import ma.zs.alc.bean.core.courseref.CategorieSection;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class CategorieSectionSpecification extends  AbstractSpecification<CategorieSectionCriteria, CategorieSection>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicateInt("numeroOrder", criteria.getNumeroOrder(), criteria.getNumeroOrderMin(), criteria.getNumeroOrderMax());
        addPredicateFk("superCategorieSection","id", criteria.getSuperCategorieSection()==null?null:criteria.getSuperCategorieSection().getId());
        addPredicateFk("superCategorieSection","id", criteria.getSuperCategorieSections());
        addPredicateFk("superCategorieSection","code", criteria.getSuperCategorieSection()==null?null:criteria.getSuperCategorieSection().getCode());
    }

    public CategorieSectionSpecification(CategorieSectionCriteria criteria) {
        super(criteria);
    }

    public CategorieSectionSpecification(CategorieSectionCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
