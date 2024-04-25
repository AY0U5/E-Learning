package  ma.zs.alc.dao.specification.core.faq;

import ma.zs.alc.dao.criteria.core.faq.FaqTypeCriteria;
import ma.zs.alc.bean.core.faq.FaqType;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class FaqTypeSpecification extends  AbstractSpecification<FaqTypeCriteria, FaqType>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public FaqTypeSpecification(FaqTypeCriteria criteria) {
        super(criteria);
    }

    public FaqTypeSpecification(FaqTypeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
