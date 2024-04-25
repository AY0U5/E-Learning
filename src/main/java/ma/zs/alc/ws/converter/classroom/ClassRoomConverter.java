package  ma.zs.alc.ws.converter.classroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.alc.zynerator.util.ListUtil;

import ma.zs.alc.ws.converter.quiz.QuizConverter;
import ma.zs.alc.ws.converter.inscriptionref.EtudiantClassRoomConverter;
import ma.zs.alc.ws.converter.inscription.EtudiantConverter;
import ma.zs.alc.ws.converter.quiz.QuizClassRoomConverter;
import ma.zs.alc.ws.converter.prof.ProfConverter;

import ma.zs.alc.bean.core.prof.Prof;


import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.classroom.ClassRoom;
import ma.zs.alc.ws.dto.classroom.ClassRoomDto;

@Component
public class ClassRoomConverter extends AbstractConverter<ClassRoom, ClassRoomDto> {

    @Autowired
    private QuizConverter quizConverter ;
    @Autowired
    private EtudiantClassRoomConverter etudiantClassRoomConverter ;
    @Autowired
    private EtudiantConverter etudiantConverter ;
    @Autowired
    private QuizClassRoomConverter quizClassRoomConverter ;
    @Autowired
    private ProfConverter profConverter ;
    private boolean prof;
    private boolean etudiantClassRooms;
    private boolean quizClassRooms;

    public  ClassRoomConverter() {
        super(ClassRoom.class, ClassRoomDto.class);
        init(true);
    }

    @Override
    public ClassRoom toItem(ClassRoomDto dto) {
        if (dto == null) {
            return null;
        } else {
        ClassRoom item = new ClassRoom();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(dto.getProf() != null && dto.getProf().getId() != null){
                item.setProf(new Prof());
                item.getProf().setId(dto.getProf().getId());
                item.getProf().setRef(dto.getProf().getRef());
            }


            if(this.etudiantClassRooms && ListUtil.isNotEmpty(dto.getEtudiantClassRooms()))
                item.setEtudiantClassRooms(etudiantClassRoomConverter.toItem(dto.getEtudiantClassRooms()));
            if(this.quizClassRooms && ListUtil.isNotEmpty(dto.getQuizClassRooms()))
                item.setQuizClassRooms(quizClassRoomConverter.toItem(dto.getQuizClassRooms()));


        return item;
        }
    }

    @Override
    public ClassRoomDto toDto(ClassRoom item) {
        if (item == null) {
            return null;
        } else {
            ClassRoomDto dto = new ClassRoomDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
            if(this.prof && item.getProf()!=null) {
                dto.setProf(profConverter.toDto(item.getProf())) ;

            }
        if(this.etudiantClassRooms && ListUtil.isNotEmpty(item.getEtudiantClassRooms())){
            etudiantClassRoomConverter.init(true);
            etudiantClassRoomConverter.setClassRoom(false);
            dto.setEtudiantClassRooms(etudiantClassRoomConverter.toDto(item.getEtudiantClassRooms()));
            etudiantClassRoomConverter.setClassRoom(true);

        }
        if(this.quizClassRooms && ListUtil.isNotEmpty(item.getQuizClassRooms())){
            quizClassRoomConverter.init(true);
            quizClassRoomConverter.setClassRoom(false);
            dto.setQuizClassRooms(quizClassRoomConverter.toDto(item.getQuizClassRooms()));
            quizClassRoomConverter.setClassRoom(true);

        }


        return dto;
        }
    }

    public void copy(ClassRoomDto dto, ClassRoom t) {
    super.copy(dto, t);
    if (dto.getProf() != null)
        profConverter.copy(dto.getProf(), t.getProf());
    if (dto.getEtudiantClassRooms() != null)
        t.setEtudiantClassRooms(etudiantClassRoomConverter.copy(dto.getEtudiantClassRooms()));
    if (dto.getQuizClassRooms() != null)
        t.setQuizClassRooms(quizClassRoomConverter.copy(dto.getQuizClassRooms()));
    }


    public void initList(boolean value) {
        this.etudiantClassRooms = value;
        this.quizClassRooms = value;
    }

    public void initObject(boolean value) {
        this.prof = value;
    }


    public QuizConverter getQuizConverter(){
        return this.quizConverter;
    }
    public void setQuizConverter(QuizConverter quizConverter ){
        this.quizConverter = quizConverter;
    }
    public EtudiantClassRoomConverter getEtudiantClassRoomConverter(){
        return this.etudiantClassRoomConverter;
    }
    public void setEtudiantClassRoomConverter(EtudiantClassRoomConverter etudiantClassRoomConverter ){
        this.etudiantClassRoomConverter = etudiantClassRoomConverter;
    }
    public EtudiantConverter getEtudiantConverter(){
        return this.etudiantConverter;
    }
    public void setEtudiantConverter(EtudiantConverter etudiantConverter ){
        this.etudiantConverter = etudiantConverter;
    }
    public QuizClassRoomConverter getQuizClassRoomConverter(){
        return this.quizClassRoomConverter;
    }
    public void setQuizClassRoomConverter(QuizClassRoomConverter quizClassRoomConverter ){
        this.quizClassRoomConverter = quizClassRoomConverter;
    }
    public ProfConverter getProfConverter(){
        return this.profConverter;
    }
    public void setProfConverter(ProfConverter profConverter ){
        this.profConverter = profConverter;
    }
    public boolean  isProf(){
        return this.prof;
    }
    public void  setProf(boolean prof){
        this.prof = prof;
    }
    public boolean  isEtudiantClassRooms(){
        return this.etudiantClassRooms ;
    }
    public void  setEtudiantClassRooms(boolean etudiantClassRooms ){
        this.etudiantClassRooms  = etudiantClassRooms ;
    }
    public boolean  isQuizClassRooms(){
        return this.quizClassRooms ;
    }
    public void  setQuizClassRooms(boolean quizClassRooms ){
        this.quizClassRooms  = quizClassRooms ;
    }
}
