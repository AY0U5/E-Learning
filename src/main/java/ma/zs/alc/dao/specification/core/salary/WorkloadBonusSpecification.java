package  ma.zs.alc.dao.specification.core.salary;

import ma.zs.alc.dao.criteria.core.salary.WorkloadBonusCriteria;
import ma.zs.alc.bean.core.salary.WorkloadBonus;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class WorkloadBonusSpecification extends  AbstractSpecification<WorkloadBonusCriteria, WorkloadBonus>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicateInt("nombreSession", criteria.getNombreSession(), criteria.getNombreSessionMin(), criteria.getNombreSessionMax());
        addPredicateBigDecimal("prix", criteria.getPrix(), criteria.getPrixMin(), criteria.getPrixMax());
    }

    public WorkloadBonusSpecification(WorkloadBonusCriteria criteria) {
        super(criteria);
    }

    public WorkloadBonusSpecification(WorkloadBonusCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
