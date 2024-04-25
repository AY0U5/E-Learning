package  ma.zs.alc.dao.specification.core.inscriptionref;

import ma.zs.alc.dao.criteria.core.inscriptionref.SkillCriteria;
import ma.zs.alc.bean.core.inscriptionref.Skill;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class SkillSpecification extends  AbstractSpecification<SkillCriteria, Skill>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public SkillSpecification(SkillCriteria criteria) {
        super(criteria);
    }

    public SkillSpecification(SkillCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
