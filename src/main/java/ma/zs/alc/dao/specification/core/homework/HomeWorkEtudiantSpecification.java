package  ma.zs.alc.dao.specification.core.homework;

import ma.zs.alc.dao.criteria.core.homework.HomeWorkEtudiantCriteria;
import ma.zs.alc.bean.core.homework.HomeWorkEtudiant;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class HomeWorkEtudiantSpecification extends  AbstractSpecification<HomeWorkEtudiantCriteria, HomeWorkEtudiant>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("note", criteria.getNote(), criteria.getNoteMin(), criteria.getNoteMax());
        addPredicate("resultat", criteria.getResultat(),criteria.getResultatLike());
        addPredicate("dateHomeWork", criteria.getDateHomeWork(), criteria.getDateHomeWorkFrom(), criteria.getDateHomeWorkTo());
        addPredicateFk("etudiant","id", criteria.getEtudiant()==null?null:criteria.getEtudiant().getId());
        addPredicateFk("etudiant","id", criteria.getEtudiants());
        addPredicateFk("etudiant","ref", criteria.getEtudiant()==null?null:criteria.getEtudiant().getRef());
        addPredicateFk("homeWork","id", criteria.getHomeWork()==null?null:criteria.getHomeWork().getId());
        addPredicateFk("homeWork","id", criteria.getHomeWorks());
    }

    public HomeWorkEtudiantSpecification(HomeWorkEtudiantCriteria criteria) {
        super(criteria);
    }

    public HomeWorkEtudiantSpecification(HomeWorkEtudiantCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
