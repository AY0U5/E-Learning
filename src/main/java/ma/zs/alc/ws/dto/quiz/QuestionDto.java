package  ma.zs.alc.ws.dto.quiz;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.math.BigDecimal;


import ma.zs.alc.ws.dto.quizref.TypeDeQuestionDto;
import ma.zs.alc.ws.dto.homework.HomeWorkDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionDto  extends AuditBaseDto {

    private String ref  ;
    private String libelle  ;
    private String urlImg  ;
    private String urlVideo  ;
    private Long numero  ;
    private BigDecimal pointReponseJuste  ;
    private BigDecimal pointReponsefausse  ;

    private TypeDeQuestionDto typeDeQuestion ;
    private QuizDto quiz ;
    private HomeWorkDto homeWork ;

    private List<ReponseDto> reponses ;


    public QuestionDto(){
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
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Log
    public String getUrlImg(){
        return this.urlImg;
    }
    public void setUrlImg(String urlImg){
        this.urlImg = urlImg;
    }

    @Log
    public String getUrlVideo(){
        return this.urlVideo;
    }
    public void setUrlVideo(String urlVideo){
        this.urlVideo = urlVideo;
    }

    @Log
    public Long getNumero(){
        return this.numero;
    }
    public void setNumero(Long numero){
        this.numero = numero;
    }

    @Log
    public BigDecimal getPointReponseJuste(){
        return this.pointReponseJuste;
    }
    public void setPointReponseJuste(BigDecimal pointReponseJuste){
        this.pointReponseJuste = pointReponseJuste;
    }

    @Log
    public BigDecimal getPointReponsefausse(){
        return this.pointReponsefausse;
    }
    public void setPointReponsefausse(BigDecimal pointReponsefausse){
        this.pointReponsefausse = pointReponsefausse;
    }


    public TypeDeQuestionDto getTypeDeQuestion(){
        return this.typeDeQuestion;
    }

    public void setTypeDeQuestion(TypeDeQuestionDto typeDeQuestion){
        this.typeDeQuestion = typeDeQuestion;
    }
    public QuizDto getQuiz(){
        return this.quiz;
    }

    public void setQuiz(QuizDto quiz){
        this.quiz = quiz;
    }
    public HomeWorkDto getHomeWork(){
        return this.homeWork;
    }

    public void setHomeWork(HomeWorkDto homeWork){
        this.homeWork = homeWork;
    }



    public List<ReponseDto> getReponses(){
        return this.reponses;
    }

    public void setReponses(List<ReponseDto> reponses){
        this.reponses = reponses;
    }



}
