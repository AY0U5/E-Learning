package  ma.zs.alc.dao.specification.core.course;

import ma.zs.alc.dao.criteria.core.course.CoursCriteria;
import ma.zs.alc.bean.core.course.Cours;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class CoursSpecification extends  AbstractSpecification<CoursCriteria, Cours>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("image", criteria.getImage(),criteria.getImageLike());
        addPredicateInt("nombreSectionFinalise", criteria.getNombreSectionFinalise(), criteria.getNombreSectionFinaliseMin(), criteria.getNombreSectionFinaliseMax());
        addPredicateInt("nombreSectionEnCours", criteria.getNombreSectionEnCours(), criteria.getNombreSectionEnCoursMin(), criteria.getNombreSectionEnCoursMax());
        addPredicateInt("nombreLinkEnCours", criteria.getNombreLinkEnCours(), criteria.getNombreLinkEnCoursMin(), criteria.getNombreLinkEnCoursMax());
        addPredicateInt("nombreLinkFinalise", criteria.getNombreLinkFinalise(), criteria.getNombreLinkFinaliseMin(), criteria.getNombreLinkFinaliseMax());
        addPredicateInt("numeroOrder", criteria.getNumeroOrder(), criteria.getNumeroOrderMin(), criteria.getNumeroOrderMax());
        addPredicateFk("etatCours","id", criteria.getEtatCours()==null?null:criteria.getEtatCours().getId());
        addPredicateFk("etatCours","id", criteria.getEtatCourss());
        addPredicateFk("etatCours","code", criteria.getEtatCours()==null?null:criteria.getEtatCours().getCode());
        addPredicateFk("parcours","id", criteria.getParcours()==null?null:criteria.getParcours().getId());
        addPredicateFk("parcours","id", criteria.getParcourss());
        addPredicateFk("parcours","code", criteria.getParcours()==null?null:criteria.getParcours().getCode());
    }

    public CoursSpecification(CoursCriteria criteria) {
        super(criteria);
    }

    public CoursSpecification(CoursCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
