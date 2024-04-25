package  ma.zs.alc.dao.specification.core.grpe;

import ma.zs.alc.dao.criteria.core.grpe.GroupeEtudiantDetailCriteria;
import ma.zs.alc.bean.core.grpe.GroupeEtudiantDetail;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class GroupeEtudiantDetailSpecification extends  AbstractSpecification<GroupeEtudiantDetailCriteria, GroupeEtudiantDetail>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateFk("groupeEtudiant","id", criteria.getGroupeEtudiant()==null?null:criteria.getGroupeEtudiant().getId());
        addPredicateFk("groupeEtudiant","id", criteria.getGroupeEtudiants());
        addPredicateFk("etudiant","id", criteria.getEtudiant()==null?null:criteria.getEtudiant().getId());
        addPredicateFk("etudiant","id", criteria.getEtudiants());
        addPredicateFk("etudiant","ref", criteria.getEtudiant()==null?null:criteria.getEtudiant().getRef());
    }

    public GroupeEtudiantDetailSpecification(GroupeEtudiantDetailCriteria criteria) {
        super(criteria);
    }

    public GroupeEtudiantDetailSpecification(GroupeEtudiantDetailCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
