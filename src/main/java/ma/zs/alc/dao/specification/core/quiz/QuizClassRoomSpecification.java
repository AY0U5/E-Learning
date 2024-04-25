package  ma.zs.alc.dao.specification.core.quiz;

import ma.zs.alc.dao.criteria.core.quiz.QuizClassRoomCriteria;
import ma.zs.alc.bean.core.quiz.QuizClassRoom;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class QuizClassRoomSpecification extends  AbstractSpecification<QuizClassRoomCriteria, QuizClassRoom>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateFk("classRoom","id", criteria.getClassRoom()==null?null:criteria.getClassRoom().getId());
        addPredicateFk("classRoom","id", criteria.getClassRooms());
        addPredicateFk("quiz","id", criteria.getQuiz()==null?null:criteria.getQuiz().getId());
        addPredicateFk("quiz","id", criteria.getQuizs());
        addPredicateFk("quiz","ref", criteria.getQuiz()==null?null:criteria.getQuiz().getRef());
    }

    public QuizClassRoomSpecification(QuizClassRoomCriteria criteria) {
        super(criteria);
    }

    public QuizClassRoomSpecification(QuizClassRoomCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
