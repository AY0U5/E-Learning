package  ma.zs.alc.dao.specification.core.grpe;

import ma.zs.alc.dao.criteria.core.grpe.GroupeTypeCriteria;
import ma.zs.alc.bean.core.grpe.GroupeType;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class GroupeTypeSpecification extends  AbstractSpecification<GroupeTypeCriteria, GroupeType>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public GroupeTypeSpecification(GroupeTypeCriteria criteria) {
        super(criteria);
    }

    public GroupeTypeSpecification(GroupeTypeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
