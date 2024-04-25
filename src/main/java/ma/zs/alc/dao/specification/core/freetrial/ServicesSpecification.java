package  ma.zs.alc.dao.specification.core.freetrial;

import ma.zs.alc.dao.criteria.core.freetrial.ServicesCriteria;
import ma.zs.alc.bean.core.freetrial.Services;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class ServicesSpecification extends  AbstractSpecification<ServicesCriteria, Services>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public ServicesSpecification(ServicesCriteria criteria) {
        super(criteria);
    }

    public ServicesSpecification(ServicesCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
