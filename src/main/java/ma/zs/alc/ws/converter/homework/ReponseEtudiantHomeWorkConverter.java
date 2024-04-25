package  ma.zs.alc.ws.converter.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.alc.ws.converter.homework.HoweWorkQSTReponseConverter;
import ma.zs.alc.ws.converter.homework.HomeWorkEtudiantConverter;
import ma.zs.alc.ws.converter.homework.HomeWorkQuestionConverter;

import ma.zs.alc.bean.core.homework.HomeWorkEtudiant;
import ma.zs.alc.bean.core.homework.HomeWorkQuestion;


import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.homework.ReponseEtudiantHomeWork;
import ma.zs.alc.ws.dto.homework.ReponseEtudiantHomeWorkDto;

@Component
public class ReponseEtudiantHomeWorkConverter extends AbstractConverter<ReponseEtudiantHomeWork, ReponseEtudiantHomeWorkDto> {

    @Autowired
    private HoweWorkQSTReponseConverter howeWorkQSTReponseConverter ;
    @Autowired
    private HomeWorkEtudiantConverter homeWorkEtudiantConverter ;
    @Autowired
    private HomeWorkQuestionConverter homeWorkQuestionConverter ;
    private boolean howeWorkQSTReponse;
    private boolean homeWorkEtudiant;
    private boolean homeWorkQuestion;

    public  ReponseEtudiantHomeWorkConverter() {
        super(ReponseEtudiantHomeWork.class, ReponseEtudiantHomeWorkDto.class);
        init(true);
    }

    @Override
    public ReponseEtudiantHomeWork toItem(ReponseEtudiantHomeWorkDto dto) {
        if (dto == null) {
            return null;
        } else {
        ReponseEtudiantHomeWork item = new ReponseEtudiantHomeWork();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getAnswer()))
                item.setAnswer(dto.getAnswer());
            if(StringUtil.isNotEmpty(dto.getProfNote()))
                item.setProfNote(dto.getProfNote());
            if(StringUtil.isNotEmpty(dto.getNote()))
                item.setNote(dto.getNote());
            if(this.howeWorkQSTReponse && dto.getHoweWorkQSTReponse()!=null)
                item.setHoweWorkQSTReponse(howeWorkQSTReponseConverter.toItem(dto.getHoweWorkQSTReponse())) ;

            if(dto.getHomeWorkEtudiant() != null && dto.getHomeWorkEtudiant().getId() != null){
                item.setHomeWorkEtudiant(new HomeWorkEtudiant());
                item.getHomeWorkEtudiant().setId(dto.getHomeWorkEtudiant().getId());
                item.getHomeWorkEtudiant().setId(dto.getHomeWorkEtudiant().getId());
            }

            if(dto.getHomeWorkQuestion() != null && dto.getHomeWorkQuestion().getId() != null){
                item.setHomeWorkQuestion(new HomeWorkQuestion());
                item.getHomeWorkQuestion().setId(dto.getHomeWorkQuestion().getId());
                item.getHomeWorkQuestion().setLibelle(dto.getHomeWorkQuestion().getLibelle());
            }




        return item;
        }
    }

    @Override
    public ReponseEtudiantHomeWorkDto toDto(ReponseEtudiantHomeWork item) {
        if (item == null) {
            return null;
        } else {
            ReponseEtudiantHomeWorkDto dto = new ReponseEtudiantHomeWorkDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getAnswer()))
                dto.setAnswer(item.getAnswer());
            if(StringUtil.isNotEmpty(item.getProfNote()))
                dto.setProfNote(item.getProfNote());
            if(StringUtil.isNotEmpty(item.getNote()))
                dto.setNote(item.getNote());
            if(this.howeWorkQSTReponse && item.getHoweWorkQSTReponse()!=null) {
                dto.setHoweWorkQSTReponse(howeWorkQSTReponseConverter.toDto(item.getHoweWorkQSTReponse())) ;

            }
            if(this.homeWorkEtudiant && item.getHomeWorkEtudiant()!=null) {
                dto.setHomeWorkEtudiant(homeWorkEtudiantConverter.toDto(item.getHomeWorkEtudiant())) ;

            }
            if(this.homeWorkQuestion && item.getHomeWorkQuestion()!=null) {
                dto.setHomeWorkQuestion(homeWorkQuestionConverter.toDto(item.getHomeWorkQuestion())) ;

            }


        return dto;
        }
    }

    public void copy(ReponseEtudiantHomeWorkDto dto, ReponseEtudiantHomeWork t) {
    super.copy(dto, t);
    if (dto.getHoweWorkQSTReponse() != null)
        howeWorkQSTReponseConverter.copy(dto.getHoweWorkQSTReponse(), t.getHoweWorkQSTReponse());
    if (dto.getHomeWorkEtudiant() != null)
        homeWorkEtudiantConverter.copy(dto.getHomeWorkEtudiant(), t.getHomeWorkEtudiant());
    if (dto.getHomeWorkQuestion() != null)
        homeWorkQuestionConverter.copy(dto.getHomeWorkQuestion(), t.getHomeWorkQuestion());
    }



    public void initObject(boolean value) {
        this.howeWorkQSTReponse = value;
        this.homeWorkEtudiant = value;
        this.homeWorkQuestion = value;
    }


    public HoweWorkQSTReponseConverter getHoweWorkQSTReponseConverter(){
        return this.howeWorkQSTReponseConverter;
    }
    public void setHoweWorkQSTReponseConverter(HoweWorkQSTReponseConverter howeWorkQSTReponseConverter ){
        this.howeWorkQSTReponseConverter = howeWorkQSTReponseConverter;
    }
    public HomeWorkEtudiantConverter getHomeWorkEtudiantConverter(){
        return this.homeWorkEtudiantConverter;
    }
    public void setHomeWorkEtudiantConverter(HomeWorkEtudiantConverter homeWorkEtudiantConverter ){
        this.homeWorkEtudiantConverter = homeWorkEtudiantConverter;
    }
    public HomeWorkQuestionConverter getHomeWorkQuestionConverter(){
        return this.homeWorkQuestionConverter;
    }
    public void setHomeWorkQuestionConverter(HomeWorkQuestionConverter homeWorkQuestionConverter ){
        this.homeWorkQuestionConverter = homeWorkQuestionConverter;
    }
    public boolean  isHoweWorkQSTReponse(){
        return this.howeWorkQSTReponse;
    }
    public void  setHoweWorkQSTReponse(boolean howeWorkQSTReponse){
        this.howeWorkQSTReponse = howeWorkQSTReponse;
    }
    public boolean  isHomeWorkEtudiant(){
        return this.homeWorkEtudiant;
    }
    public void  setHomeWorkEtudiant(boolean homeWorkEtudiant){
        this.homeWorkEtudiant = homeWorkEtudiant;
    }
    public boolean  isHomeWorkQuestion(){
        return this.homeWorkQuestion;
    }
    public void  setHomeWorkQuestion(boolean homeWorkQuestion){
        this.homeWorkQuestion = homeWorkQuestion;
    }
}
