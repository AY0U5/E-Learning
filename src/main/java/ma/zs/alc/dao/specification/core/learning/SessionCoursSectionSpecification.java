package  ma.zs.alc.dao.specification.core.learning;

import ma.zs.alc.dao.criteria.core.learning.SessionCoursSectionCriteria;
import ma.zs.alc.bean.core.learning.SessionCoursSection;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class SessionCoursSectionSpecification extends  AbstractSpecification<SessionCoursSectionCriteria, SessionCoursSection>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateFk("sessionCours","id", criteria.getSessionCours()==null?null:criteria.getSessionCours().getId());
        addPredicateFk("sessionCours","id", criteria.getSessionCourss());
        addPredicateFk("sessionCours","reference", criteria.getSessionCours()==null?null:criteria.getSessionCours().getReference());
        addPredicateFk("section","id", criteria.getSection()==null?null:criteria.getSection().getId());
        addPredicateFk("section","id", criteria.getSections());
        addPredicateFk("section","code", criteria.getSection()==null?null:criteria.getSection().getCode());
    }

    public SessionCoursSectionSpecification(SessionCoursSectionCriteria criteria) {
        super(criteria);
    }

    public SessionCoursSectionSpecification(SessionCoursSectionCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
