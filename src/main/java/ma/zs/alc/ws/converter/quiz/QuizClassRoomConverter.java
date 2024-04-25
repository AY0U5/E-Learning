package  ma.zs.alc.ws.converter.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.alc.ws.converter.quiz.QuizConverter;
import ma.zs.alc.ws.converter.classroom.ClassRoomConverter;

import ma.zs.alc.bean.core.classroom.ClassRoom;
import ma.zs.alc.bean.core.quiz.Quiz;


import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.quiz.QuizClassRoom;
import ma.zs.alc.ws.dto.quiz.QuizClassRoomDto;

@Component
public class QuizClassRoomConverter extends AbstractConverter<QuizClassRoom, QuizClassRoomDto> {

    @Autowired
    private QuizConverter quizConverter ;
    @Autowired
    private ClassRoomConverter classRoomConverter ;
    private boolean classRoom;
    private boolean quiz;

    public  QuizClassRoomConverter() {
        super(QuizClassRoom.class, QuizClassRoomDto.class);
        init(true);
    }

    @Override
    public QuizClassRoom toItem(QuizClassRoomDto dto) {
        if (dto == null) {
            return null;
        } else {
        QuizClassRoom item = new QuizClassRoom();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(dto.getClassRoom() != null && dto.getClassRoom().getId() != null){
                item.setClassRoom(new ClassRoom());
                item.getClassRoom().setId(dto.getClassRoom().getId());
                item.getClassRoom().setLibelle(dto.getClassRoom().getLibelle());
            }

            if(dto.getQuiz() != null && dto.getQuiz().getId() != null){
                item.setQuiz(new Quiz());
                item.getQuiz().setId(dto.getQuiz().getId());
                item.getQuiz().setLib(dto.getQuiz().getLib());
            }




        return item;
        }
    }

    @Override
    public QuizClassRoomDto toDto(QuizClassRoom item) {
        if (item == null) {
            return null;
        } else {
            QuizClassRoomDto dto = new QuizClassRoomDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(this.classRoom && item.getClassRoom()!=null) {
                dto.setClassRoom(classRoomConverter.toDto(item.getClassRoom())) ;

            }
            if(this.quiz && item.getQuiz()!=null) {
                dto.setQuiz(quizConverter.toDto(item.getQuiz())) ;

            }


        return dto;
        }
    }

    public void copy(QuizClassRoomDto dto, QuizClassRoom t) {
    super.copy(dto, t);
    if (dto.getClassRoom() != null)
        classRoomConverter.copy(dto.getClassRoom(), t.getClassRoom());
    if (dto.getQuiz() != null)
        quizConverter.copy(dto.getQuiz(), t.getQuiz());
    }



    public void initObject(boolean value) {
        this.classRoom = value;
        this.quiz = value;
    }


    public QuizConverter getQuizConverter(){
        return this.quizConverter;
    }
    public void setQuizConverter(QuizConverter quizConverter ){
        this.quizConverter = quizConverter;
    }
    public ClassRoomConverter getClassRoomConverter(){
        return this.classRoomConverter;
    }
    public void setClassRoomConverter(ClassRoomConverter classRoomConverter ){
        this.classRoomConverter = classRoomConverter;
    }
    public boolean  isClassRoom(){
        return this.classRoom;
    }
    public void  setClassRoom(boolean classRoom){
        this.classRoom = classRoom;
    }
    public boolean  isQuiz(){
        return this.quiz;
    }
    public void  setQuiz(boolean quiz){
        this.quiz = quiz;
    }
}
