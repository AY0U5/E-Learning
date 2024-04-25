package  ma.zs.alc.dao.specification.core.common;

import ma.zs.alc.dao.criteria.core.common.ContactCriteria;
import ma.zs.alc.bean.core.common.Contact;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class ContactSpecification extends  AbstractSpecification<ContactCriteria, Contact>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("name", criteria.getName(),criteria.getNameLike());
        addPredicate("email", criteria.getEmail(),criteria.getEmailLike());
        addPredicate("phone", criteria.getPhone(),criteria.getPhoneLike());
        addPredicate("setFrom", criteria.getSetFrom(),criteria.getSetFromLike());
        addPredicate("dateContact", criteria.getDateContact(), criteria.getDateContactFrom(), criteria.getDateContactTo());
        addPredicateBool("replied", criteria.getReplied());
    }

    public ContactSpecification(ContactCriteria criteria) {
        super(criteria);
    }

    public ContactSpecification(ContactCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
