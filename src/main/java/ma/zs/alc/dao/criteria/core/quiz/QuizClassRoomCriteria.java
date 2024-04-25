package  ma.zs.alc.dao.criteria.core.quiz;


import ma.zs.alc.dao.criteria.core.classroom.ClassRoomCriteria;

import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;

public class QuizClassRoomCriteria extends  BaseCriteria  {


    private ClassRoomCriteria classRoom ;
    private List<ClassRoomCriteria> classRooms ;
    private QuizCriteria quiz ;
    private List<QuizCriteria> quizs ;


    public QuizClassRoomCriteria(){}


    public ClassRoomCriteria getClassRoom(){
        return this.classRoom;
    }

    public void setClassRoom(ClassRoomCriteria classRoom){
        this.classRoom = classRoom;
    }
    public List<ClassRoomCriteria> getClassRooms(){
        return this.classRooms;
    }

    public void setClassRooms(List<ClassRoomCriteria> classRooms){
        this.classRooms = classRooms;
    }
    public QuizCriteria getQuiz(){
        return this.quiz;
    }

    public void setQuiz(QuizCriteria quiz){
        this.quiz = quiz;
    }
    public List<QuizCriteria> getQuizs(){
        return this.quizs;
    }

    public void setQuizs(List<QuizCriteria> quizs){
        this.quizs = quizs;
    }
}
