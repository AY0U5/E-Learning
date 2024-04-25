package  ma.zs.alc.ws.dto.homework;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


import ma.zs.alc.ws.dto.quizref.TypeDeQuestionDto;
import ma.zs.alc.ws.dto.inscription.EtudiantDto;
import ma.zs.alc.ws.dto.course.CoursDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class HomeWorkDto  extends AuditBaseDto {

    private String libelle  ;
    private String urlImage  ;
    private String urlVideo  ;

    private CoursDto cours ;
    private TypeHomeWorkDto typeHomeWork ;

    private List<HomeWorkQuestionDto> homeWorkQuestions ;
    private List<HomeWorkEtudiantDto> homeWorkEtudiants ;


    public HomeWorkDto(){
        super();
    }



    @Log
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Log
    public String getUrlImage(){
        return this.urlImage;
    }
    public void setUrlImage(String urlImage){
        this.urlImage = urlImage;
    }

    @Log
    public String getUrlVideo(){
        return this.urlVideo;
    }
    public void setUrlVideo(String urlVideo){
        this.urlVideo = urlVideo;
    }


    public CoursDto getCours(){
        return this.cours;
    }

    public void setCours(CoursDto cours){
        this.cours = cours;
    }
    public TypeHomeWorkDto getTypeHomeWork(){
        return this.typeHomeWork;
    }

    public void setTypeHomeWork(TypeHomeWorkDto typeHomeWork){
        this.typeHomeWork = typeHomeWork;
    }



    public List<HomeWorkQuestionDto> getHomeWorkQuestions(){
        return this.homeWorkQuestions;
    }

    public void setHomeWorkQuestions(List<HomeWorkQuestionDto> homeWorkQuestions){
        this.homeWorkQuestions = homeWorkQuestions;
    }
    public List<HomeWorkEtudiantDto> getHomeWorkEtudiants(){
        return this.homeWorkEtudiants;
    }

    public void setHomeWorkEtudiants(List<HomeWorkEtudiantDto> homeWorkEtudiants){
        this.homeWorkEtudiants = homeWorkEtudiants;
    }



}
