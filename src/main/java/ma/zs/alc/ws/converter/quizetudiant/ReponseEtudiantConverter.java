package  ma.zs.alc.ws.converter.quizetudiant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.alc.ws.converter.quizetudiant.QuizEtudiantConverter;
import ma.zs.alc.ws.converter.quiz.QuestionConverter;
import ma.zs.alc.ws.converter.quiz.ReponseConverter;

import ma.zs.alc.bean.core.quizetudiant.QuizEtudiant;
import ma.zs.alc.bean.core.quiz.Question;


import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.quizetudiant.ReponseEtudiant;
import ma.zs.alc.ws.dto.quizetudiant.ReponseEtudiantDto;

@Component
public class ReponseEtudiantConverter extends AbstractConverter<ReponseEtudiant, ReponseEtudiantDto> {

    @Autowired
    private QuizEtudiantConverter quizEtudiantConverter ;
    @Autowired
    private QuestionConverter questionConverter ;
    @Autowired
    private ReponseConverter reponseConverter ;
    private boolean reponse;
    private boolean quizEtudiant;
    private boolean question;

    public  ReponseEtudiantConverter() {
        super(ReponseEtudiant.class, ReponseEtudiantDto.class);
        init(true);
    }

    @Override
    public ReponseEtudiant toItem(ReponseEtudiantDto dto) {
        if (dto == null) {
            return null;
        } else {
        ReponseEtudiant item = new ReponseEtudiant();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getAnswer()))
                item.setAnswer(dto.getAnswer());
            if(StringUtil.isNotEmpty(dto.getNote()))
                item.setNote(dto.getNote());
            if(this.reponse && dto.getReponse()!=null)
                item.setReponse(reponseConverter.toItem(dto.getReponse())) ;

            if(dto.getQuizEtudiant() != null && dto.getQuizEtudiant().getId() != null){
                item.setQuizEtudiant(new QuizEtudiant());
                item.getQuizEtudiant().setId(dto.getQuizEtudiant().getId());
                item.getQuizEtudiant().setRef(dto.getQuizEtudiant().getRef());
            }

            if(dto.getQuestion() != null && dto.getQuestion().getId() != null){
                item.setQuestion(new Question());
                item.getQuestion().setId(dto.getQuestion().getId());
                item.getQuestion().setLibelle(dto.getQuestion().getLibelle());
            }




        return item;
        }
    }

    @Override
    public ReponseEtudiantDto toDto(ReponseEtudiant item) {
        if (item == null) {
            return null;
        } else {
            ReponseEtudiantDto dto = new ReponseEtudiantDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(StringUtil.isNotEmpty(item.getAnswer()))
                dto.setAnswer(item.getAnswer());
            if(StringUtil.isNotEmpty(item.getNote()))
                dto.setNote(item.getNote());
            if(this.reponse && item.getReponse()!=null) {
                dto.setReponse(reponseConverter.toDto(item.getReponse())) ;

            }
            if(this.quizEtudiant && item.getQuizEtudiant()!=null) {
                dto.setQuizEtudiant(quizEtudiantConverter.toDto(item.getQuizEtudiant())) ;

            }
            if(this.question && item.getQuestion()!=null) {
                dto.setQuestion(questionConverter.toDto(item.getQuestion())) ;

            }


        return dto;
        }
    }

    public void copy(ReponseEtudiantDto dto, ReponseEtudiant t) {
    super.copy(dto, t);
    if (dto.getReponse() != null)
        reponseConverter.copy(dto.getReponse(), t.getReponse());
    if (dto.getQuizEtudiant() != null)
        quizEtudiantConverter.copy(dto.getQuizEtudiant(), t.getQuizEtudiant());
    if (dto.getQuestion() != null)
        questionConverter.copy(dto.getQuestion(), t.getQuestion());
    }



    public void initObject(boolean value) {
        this.reponse = value;
        this.quizEtudiant = value;
        this.question = value;
    }


    public QuizEtudiantConverter getQuizEtudiantConverter(){
        return this.quizEtudiantConverter;
    }
    public void setQuizEtudiantConverter(QuizEtudiantConverter quizEtudiantConverter ){
        this.quizEtudiantConverter = quizEtudiantConverter;
    }
    public QuestionConverter getQuestionConverter(){
        return this.questionConverter;
    }
    public void setQuestionConverter(QuestionConverter questionConverter ){
        this.questionConverter = questionConverter;
    }
    public ReponseConverter getReponseConverter(){
        return this.reponseConverter;
    }
    public void setReponseConverter(ReponseConverter reponseConverter ){
        this.reponseConverter = reponseConverter;
    }
    public boolean  isReponse(){
        return this.reponse;
    }
    public void  setReponse(boolean reponse){
        this.reponse = reponse;
    }
    public boolean  isQuizEtudiant(){
        return this.quizEtudiant;
    }
    public void  setQuizEtudiant(boolean quizEtudiant){
        this.quizEtudiant = quizEtudiant;
    }
    public boolean  isQuestion(){
        return this.question;
    }
    public void  setQuestion(boolean question){
        this.question = question;
    }
}
