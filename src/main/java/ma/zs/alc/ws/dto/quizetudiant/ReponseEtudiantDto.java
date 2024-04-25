package  ma.zs.alc.ws.dto.quizetudiant;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


import ma.zs.alc.ws.dto.quiz.QuestionDto;
import ma.zs.alc.ws.dto.quiz.ReponseDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReponseEtudiantDto  extends AuditBaseDto {

    private String ref  ;
    private String answer  ;
    private BigDecimal note  ;

    private ReponseDto reponse ;
    private QuizEtudiantDto quizEtudiant ;
    private QuestionDto question ;



    public ReponseEtudiantDto(){
        super();
    }



    @Log
    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }

    @Log
    public String getAnswer(){
        return this.answer;
    }
    public void setAnswer(String answer){
        this.answer = answer;
    }

    @Log
    public BigDecimal getNote(){
        return this.note;
    }
    public void setNote(BigDecimal note){
        this.note = note;
    }


    public ReponseDto getReponse(){
        return this.reponse;
    }

    public void setReponse(ReponseDto reponse){
        this.reponse = reponse;
    }
    public QuizEtudiantDto getQuizEtudiant(){
        return this.quizEtudiant;
    }

    public void setQuizEtudiant(QuizEtudiantDto quizEtudiant){
        this.quizEtudiant = quizEtudiant;
    }
    public QuestionDto getQuestion(){
        return this.question;
    }

    public void setQuestion(QuestionDto question){
        this.question = question;
    }






}
