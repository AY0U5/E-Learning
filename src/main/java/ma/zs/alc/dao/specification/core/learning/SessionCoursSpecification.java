package  ma.zs.alc.dao.specification.core.learning;

import ma.zs.alc.dao.criteria.core.learning.SessionCoursCriteria;
import ma.zs.alc.bean.core.learning.SessionCours;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class SessionCoursSpecification extends  AbstractSpecification<SessionCoursCriteria, SessionCours>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicateBigDecimal("duree", criteria.getDuree(), criteria.getDureeMin(), criteria.getDureeMax());
        addPredicateBigDecimal("totalheure", criteria.getTotalheure(), criteria.getTotalheureMin(), criteria.getTotalheureMax());
        addPredicateBigDecimal("mois", criteria.getMois(), criteria.getMoisMin(), criteria.getMoisMax());
        addPredicateBigDecimal("annee", criteria.getAnnee(), criteria.getAnneeMin(), criteria.getAnneeMax());
        addPredicate("dateFin", criteria.getDateFin(), criteria.getDateFinFrom(), criteria.getDateFinTo());
        addPredicate("dateDebut", criteria.getDateDebut(), criteria.getDateDebutFrom(), criteria.getDateDebutTo());
        addPredicateBool("payer", criteria.getPayer());
        addPredicateFk("prof","id", criteria.getProf()==null?null:criteria.getProf().getId());
        addPredicateFk("prof","id", criteria.getProfs());
        addPredicateFk("prof","ref", criteria.getProf()==null?null:criteria.getProf().getRef());
        addPredicateFk("cours","id", criteria.getCours()==null?null:criteria.getCours().getId());
        addPredicateFk("cours","id", criteria.getCourss());
        addPredicateFk("cours","code", criteria.getCours()==null?null:criteria.getCours().getCode());
        addPredicateFk("groupeEtudiant","id", criteria.getGroupeEtudiant()==null?null:criteria.getGroupeEtudiant().getId());
        addPredicateFk("groupeEtudiant","id", criteria.getGroupeEtudiants());
        addPredicateFk("salary","id", criteria.getSalary()==null?null:criteria.getSalary().getId());
        addPredicateFk("salary","id", criteria.getSalarys());
        addPredicateFk("salary","code", criteria.getSalary()==null?null:criteria.getSalary().getCode());
    }

    public SessionCoursSpecification(SessionCoursCriteria criteria) {
        super(criteria);
    }

    public SessionCoursSpecification(SessionCoursCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
