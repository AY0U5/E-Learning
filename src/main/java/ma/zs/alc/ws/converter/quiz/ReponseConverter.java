package  ma.zs.alc.ws.converter.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.alc.ws.converter.quiz.QuestionConverter;

import ma.zs.alc.bean.core.quiz.Question;


import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.quiz.Reponse;
import ma.zs.alc.ws.dto.quiz.ReponseDto;

@Component
public class ReponseConverter extends AbstractConverter<Reponse, ReponseDto> {

    @Autowired
    private QuestionConverter questionConverter ;
    private boolean question;

    public  ReponseConverter() {
        super(Reponse.class, ReponseDto.class);
        init(true);
    }

    @Override
    public Reponse toItem(ReponseDto dto) {
        if (dto == null) {
            return null;
        } else {
        Reponse item = new Reponse();
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
            if(dto.getQuestion() != null && dto.getQuestion().getId() != null){
                item.setQuestion(new Question());
                item.getQuestion().setId(dto.getQuestion().getId());
                item.getQuestion().setLibelle(dto.getQuestion().getLibelle());
            }




        return item;
        }
    }

    @Override
    public ReponseDto toDto(Reponse item) {
        if (item == null) {
            return null;
        } else {
            ReponseDto dto = new ReponseDto();
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
            if(this.question && item.getQuestion()!=null) {
                dto.setQuestion(questionConverter.toDto(item.getQuestion())) ;

            }


        return dto;
        }
    }

    public void copy(ReponseDto dto, Reponse t) {
    super.copy(dto, t);
    if (dto.getQuestion() != null)
        questionConverter.copy(dto.getQuestion(), t.getQuestion());
    }



    public void initObject(boolean value) {
        this.question = value;
    }


    public QuestionConverter getQuestionConverter(){
        return this.questionConverter;
    }
    public void setQuestionConverter(QuestionConverter questionConverter ){
        this.questionConverter = questionConverter;
    }
    public boolean  isQuestion(){
        return this.question;
    }
    public void  setQuestion(boolean question){
        this.question = question;
    }
}
