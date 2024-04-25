package  ma.zs.alc.dao.specification.core.pack;

import ma.zs.alc.dao.criteria.core.pack.PackStudentCriteria;
import ma.zs.alc.bean.core.pack.PackStudent;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class PackStudentSpecification extends  AbstractSpecification<PackStudentCriteria, PackStudent>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateInt("nombreCours", criteria.getNombreCours(), criteria.getNombreCoursMin(), criteria.getNombreCoursMax());
        addPredicateBool("forGroupe", criteria.getForGroupe());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("preRequisites", criteria.getPreRequisites(),criteria.getPreRequisitesLike());
        addPredicate("whyTakeThisCourse", criteria.getWhyTakeThisCourse(),criteria.getWhyTakeThisCourseLike());
        addPredicate("expectations", criteria.getExpectations(),criteria.getExpectationsLike());
        addPredicate("imgUrl", criteria.getImgUrl(),criteria.getImgUrlLike());
        addPredicateInt("totalStudents", criteria.getTotalStudents(), criteria.getTotalStudentsMin(), criteria.getTotalStudentsMax());
        addPredicate("rating", criteria.getRating(),criteria.getRatingLike());
        addPredicate("oldPrice", criteria.getOldPrice(),criteria.getOldPriceLike());
        addPredicateFk("parcours","id", criteria.getParcours()==null?null:criteria.getParcours().getId());
        addPredicateFk("parcours","id", criteria.getParcourss());
        addPredicateFk("parcours","code", criteria.getParcours()==null?null:criteria.getParcours().getCode());
        addPredicateFk("price","id", criteria.getPrice()==null?null:criteria.getPrice().getId());
        addPredicateFk("price","id", criteria.getPrices());
    }

    public PackStudentSpecification(PackStudentCriteria criteria) {
        super(criteria);
    }

    public PackStudentSpecification(PackStudentCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
