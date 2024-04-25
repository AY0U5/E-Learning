package  ma.zs.alc.ws.converter.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.alc.ws.converter.homework.HomeWorkQuestionConverter;

import ma.zs.alc.bean.core.homework.HomeWorkQuestion;


import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.homework.HoweWorkQSTReponse;
import ma.zs.alc.ws.dto.homework.HoweWorkQSTReponseDto;

@Component
public class HoweWorkQSTReponseConverter extends AbstractConverter<HoweWorkQSTReponse, HoweWorkQSTReponseDto> {

    @Autowired
    private HomeWorkQuestionConverter homeWorkQuestionConverter ;
    private boolean homeWorkQuestion;

    public  HoweWorkQSTReponseConverter() {
        super(HoweWorkQSTReponse.class, HoweWorkQSTReponseDto.class);
        init(true);
    }

    @Override
    public HoweWorkQSTReponse toItem(HoweWorkQSTReponseDto dto) {
        if (dto == null) {
            return null;
        } else {
        HoweWorkQSTReponse item = new HoweWorkQSTReponse();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getLib()))
                item.setLib(dto.getLib());
            if(StringUtil.isNotEmpty(dto.getEtatReponse()))
                item.setEtatReponse(dto.getEtatReponse());
            if(StringUtil.isNotEmpty(dto.getNumero()))
                item.setNumero(dto.getNumero());
            if(dto.getHomeWorkQuestion() != null && dto.getHomeWorkQuestion().getId() != null){
                item.setHomeWorkQuestion(new HomeWorkQuestion());
                item.getHomeWorkQuestion().setId(dto.getHomeWorkQuestion().getId());
                item.getHomeWorkQuestion().setLibelle(dto.getHomeWorkQuestion().getLibelle());
            }




        return item;
        }
    }

    @Override
    public HoweWorkQSTReponseDto toDto(HoweWorkQSTReponse item) {
        if (item == null) {
            return null;
        } else {
            HoweWorkQSTReponseDto dto = new HoweWorkQSTReponseDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(StringUtil.isNotEmpty(item.getLib()))
                dto.setLib(item.getLib());
            if(StringUtil.isNotEmpty(item.getEtatReponse()))
                dto.setEtatReponse(item.getEtatReponse());
            if(StringUtil.isNotEmpty(item.getNumero()))
                dto.setNumero(item.getNumero());
            if(this.homeWorkQuestion && item.getHomeWorkQuestion()!=null) {
                dto.setHomeWorkQuestion(homeWorkQuestionConverter.toDto(item.getHomeWorkQuestion())) ;

            }


        return dto;
        }
    }

    public void copy(HoweWorkQSTReponseDto dto, HoweWorkQSTReponse t) {
    super.copy(dto, t);
    if (dto.getHomeWorkQuestion() != null)
        homeWorkQuestionConverter.copy(dto.getHomeWorkQuestion(), t.getHomeWorkQuestion());
    }



    public void initObject(boolean value) {
        this.homeWorkQuestion = value;
    }


    public HomeWorkQuestionConverter getHomeWorkQuestionConverter(){
        return this.homeWorkQuestionConverter;
    }
    public void setHomeWorkQuestionConverter(HomeWorkQuestionConverter homeWorkQuestionConverter ){
        this.homeWorkQuestionConverter = homeWorkQuestionConverter;
    }
    public boolean  isHomeWorkQuestion(){
        return this.homeWorkQuestion;
    }
    public void  setHomeWorkQuestion(boolean homeWorkQuestion){
        this.homeWorkQuestion = homeWorkQuestion;
    }
}
