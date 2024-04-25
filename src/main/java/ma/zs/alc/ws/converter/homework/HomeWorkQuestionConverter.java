package  ma.zs.alc.ws.converter.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.alc.zynerator.util.ListUtil;

import ma.zs.alc.ws.converter.homework.HoweWorkQSTReponseConverter;
import ma.zs.alc.ws.converter.quizref.TypeDeQuestionConverter;
import ma.zs.alc.ws.converter.homework.HomeWorkConverter;

import ma.zs.alc.bean.core.homework.HomeWork;


import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.homework.HomeWorkQuestion;
import ma.zs.alc.ws.dto.homework.HomeWorkQuestionDto;

@Component
public class HomeWorkQuestionConverter extends AbstractConverter<HomeWorkQuestion, HomeWorkQuestionDto> {

    @Autowired
    private HoweWorkQSTReponseConverter howeWorkQSTReponseConverter ;
    @Autowired
    private TypeDeQuestionConverter typeDeQuestionConverter ;
    @Autowired
    private HomeWorkConverter homeWorkConverter ;
    private boolean typeDeQuestion;
    private boolean homeWork;
    private boolean howeWorkQSTReponses;

    public  HomeWorkQuestionConverter() {
        super(HomeWorkQuestion.class, HomeWorkQuestionDto.class);
        init(true);
    }

    @Override
    public HomeWorkQuestion toItem(HomeWorkQuestionDto dto) {
        if (dto == null) {
            return null;
        } else {
        HomeWorkQuestion item = new HomeWorkQuestion();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getNumero()))
                item.setNumero(dto.getNumero());
            if(StringUtil.isNotEmpty(dto.getPointReponseJuste()))
                item.setPointReponseJuste(dto.getPointReponseJuste());
            if(StringUtil.isNotEmpty(dto.getPointReponsefausse()))
                item.setPointReponsefausse(dto.getPointReponsefausse());
            if(this.typeDeQuestion && dto.getTypeDeQuestion()!=null)
                item.setTypeDeQuestion(typeDeQuestionConverter.toItem(dto.getTypeDeQuestion())) ;

            if(dto.getHomeWork() != null && dto.getHomeWork().getId() != null){
                item.setHomeWork(new HomeWork());
                item.getHomeWork().setId(dto.getHomeWork().getId());
                item.getHomeWork().setLibelle(dto.getHomeWork().getLibelle());
            }


            if(this.howeWorkQSTReponses && ListUtil.isNotEmpty(dto.getHoweWorkQSTReponses()))
                item.setHoweWorkQSTReponses(howeWorkQSTReponseConverter.toItem(dto.getHoweWorkQSTReponses()));


        return item;
        }
    }

    @Override
    public HomeWorkQuestionDto toDto(HomeWorkQuestion item) {
        if (item == null) {
            return null;
        } else {
            HomeWorkQuestionDto dto = new HomeWorkQuestionDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getNumero()))
                dto.setNumero(item.getNumero());
            if(StringUtil.isNotEmpty(item.getPointReponseJuste()))
                dto.setPointReponseJuste(item.getPointReponseJuste());
            if(StringUtil.isNotEmpty(item.getPointReponsefausse()))
                dto.setPointReponsefausse(item.getPointReponsefausse());
            if(this.typeDeQuestion && item.getTypeDeQuestion()!=null) {
                dto.setTypeDeQuestion(typeDeQuestionConverter.toDto(item.getTypeDeQuestion())) ;

            }
            if(this.homeWork && item.getHomeWork()!=null) {
                dto.setHomeWork(homeWorkConverter.toDto(item.getHomeWork())) ;

            }
        if(this.howeWorkQSTReponses && ListUtil.isNotEmpty(item.getHoweWorkQSTReponses())){
            howeWorkQSTReponseConverter.init(true);
            howeWorkQSTReponseConverter.setHomeWorkQuestion(false);
            dto.setHoweWorkQSTReponses(howeWorkQSTReponseConverter.toDto(item.getHoweWorkQSTReponses()));
            howeWorkQSTReponseConverter.setHomeWorkQuestion(true);

        }


        return dto;
        }
    }

    public void copy(HomeWorkQuestionDto dto, HomeWorkQuestion t) {
    super.copy(dto, t);
    if (dto.getTypeDeQuestion() != null)
        typeDeQuestionConverter.copy(dto.getTypeDeQuestion(), t.getTypeDeQuestion());
    if (dto.getHoweWorkQSTReponses() != null)
        t.setHoweWorkQSTReponses(howeWorkQSTReponseConverter.copy(dto.getHoweWorkQSTReponses()));
    if (dto.getHomeWork() != null)
        homeWorkConverter.copy(dto.getHomeWork(), t.getHomeWork());
    }


    public void initList(boolean value) {
        this.howeWorkQSTReponses = value;
    }

    public void initObject(boolean value) {
        this.typeDeQuestion = value;
        this.homeWork = value;
    }


    public HoweWorkQSTReponseConverter getHoweWorkQSTReponseConverter(){
        return this.howeWorkQSTReponseConverter;
    }
    public void setHoweWorkQSTReponseConverter(HoweWorkQSTReponseConverter howeWorkQSTReponseConverter ){
        this.howeWorkQSTReponseConverter = howeWorkQSTReponseConverter;
    }
    public TypeDeQuestionConverter getTypeDeQuestionConverter(){
        return this.typeDeQuestionConverter;
    }
    public void setTypeDeQuestionConverter(TypeDeQuestionConverter typeDeQuestionConverter ){
        this.typeDeQuestionConverter = typeDeQuestionConverter;
    }
    public HomeWorkConverter getHomeWorkConverter(){
        return this.homeWorkConverter;
    }
    public void setHomeWorkConverter(HomeWorkConverter homeWorkConverter ){
        this.homeWorkConverter = homeWorkConverter;
    }
    public boolean  isTypeDeQuestion(){
        return this.typeDeQuestion;
    }
    public void  setTypeDeQuestion(boolean typeDeQuestion){
        this.typeDeQuestion = typeDeQuestion;
    }
    public boolean  isHomeWork(){
        return this.homeWork;
    }
    public void  setHomeWork(boolean homeWork){
        this.homeWork = homeWork;
    }
    public boolean  isHoweWorkQSTReponses(){
        return this.howeWorkQSTReponses ;
    }
    public void  setHoweWorkQSTReponses(boolean howeWorkQSTReponses ){
        this.howeWorkQSTReponses  = howeWorkQSTReponses ;
    }
}
