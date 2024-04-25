package  ma.zs.alc.dao.specification.core.profetudiantcours;

import ma.zs.alc.dao.criteria.core.profetudiantcours.EtudiantCoursCriteria;
import ma.zs.alc.bean.core.profetudiantcours.EtudiantCours;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class EtudiantCoursSpecification extends  AbstractSpecification<EtudiantCoursCriteria, EtudiantCours>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBool("payer", criteria.getPayer());
        addPredicate("dateFin", criteria.getDateFin(), criteria.getDateFinFrom(), criteria.getDateFinTo());
        addPredicateFk("etudiant","id", criteria.getEtudiant()==null?null:criteria.getEtudiant().getId());
        addPredicateFk("etudiant","id", criteria.getEtudiants());
        addPredicateFk("etudiant","ref", criteria.getEtudiant()==null?null:criteria.getEtudiant().getRef());
        addPredicateFk("prof","id", criteria.getProf()==null?null:criteria.getProf().getId());
        addPredicateFk("prof","id", criteria.getProfs());
        addPredicateFk("prof","ref", criteria.getProf()==null?null:criteria.getProf().getRef());
        addPredicateFk("cours","id", criteria.getCours()==null?null:criteria.getCours().getId());
        addPredicateFk("cours","id", criteria.getCourss());
        addPredicateFk("cours","code", criteria.getCours()==null?null:criteria.getCours().getCode());
    }

    public EtudiantCoursSpecification(EtudiantCoursCriteria criteria) {
        super(criteria);
    }

    public EtudiantCoursSpecification(EtudiantCoursCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
