package  ma.zs.alc.dao.specification.core.inscriptionref;

import ma.zs.alc.dao.criteria.core.inscriptionref.StatutSocialCriteria;
import ma.zs.alc.bean.core.inscriptionref.StatutSocial;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class StatutSocialSpecification extends  AbstractSpecification<StatutSocialCriteria, StatutSocial>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public StatutSocialSpecification(StatutSocialCriteria criteria) {
        super(criteria);
    }

    public StatutSocialSpecification(StatutSocialCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
