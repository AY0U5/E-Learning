package  ma.zs.alc.dao.specification.core.classroom;

import ma.zs.alc.dao.criteria.core.classroom.ClassRoomCriteria;
import ma.zs.alc.bean.core.classroom.ClassRoom;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class ClassRoomSpecification extends  AbstractSpecification<ClassRoomCriteria, ClassRoom>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicateFk("prof","id", criteria.getProf()==null?null:criteria.getProf().getId());
        addPredicateFk("prof","id", criteria.getProfs());
        addPredicateFk("prof","ref", criteria.getProf()==null?null:criteria.getProf().getRef());
    }

    public ClassRoomSpecification(ClassRoomCriteria criteria) {
        super(criteria);
    }

    public ClassRoomSpecification(ClassRoomCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
