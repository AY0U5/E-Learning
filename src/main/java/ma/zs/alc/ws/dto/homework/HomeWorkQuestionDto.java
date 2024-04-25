package  ma.zs.alc.ws.dto.homework;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.math.BigDecimal;


import ma.zs.alc.ws.dto.quizref.TypeDeQuestionDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class HomeWorkQuestionDto  extends AuditBaseDto {

    private String ref  ;
    private String libelle  ;
    private Integer numero  = 0 ;
    private BigDecimal pointReponseJuste  ;
    private BigDecimal pointReponsefausse  ;

    private TypeDeQuestionDto typeDeQuestion ;
    private HomeWorkDto homeWork ;

    private List<HoweWorkQSTReponseDto> howeWorkQSTReponses ;


    public HomeWorkQuestionDto(){
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
    public Integer getNumero(){
        return this.numero;
    }
    public void setNumero(Integer numero){
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
    public HomeWorkDto getHomeWork(){
        return this.homeWork;
    }

    public void setHomeWork(HomeWorkDto homeWork){
        this.homeWork = homeWork;
    }



    public List<HoweWorkQSTReponseDto> getHoweWorkQSTReponses(){
        return this.howeWorkQSTReponses;
    }

    public void setHoweWorkQSTReponses(List<HoweWorkQSTReponseDto> howeWorkQSTReponses){
        this.howeWorkQSTReponses = howeWorkQSTReponses;
    }



}
