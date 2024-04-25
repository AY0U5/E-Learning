package  ma.zs.alc.ws.dto.course;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


import ma.zs.alc.ws.dto.courseref.CategorieSectionDto;
import ma.zs.alc.ws.dto.homework.HomeWorkEtudiantDto;
import ma.zs.alc.ws.dto.homework.HomeWorkQuestionDto;
import ma.zs.alc.ws.dto.courseref.EtatCoursDto;
import ma.zs.alc.ws.dto.homework.TypeHomeWorkDto;
import ma.zs.alc.ws.dto.homework.HomeWorkDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class CoursDto  extends AuditBaseDto {

    private String code  ;
    private String libelle  ;
    private String description  ;
    private String image  ;
    private Integer nombreSectionFinalise  = 0 ;
    private Integer nombreSectionEnCours  = 0 ;
    private Integer nombreLinkEnCours  = 0 ;
    private Integer nombreLinkFinalise  = 0 ;
    private Integer numeroOrder  = 0 ;

    private EtatCoursDto etatCours ;
    private ParcoursDto parcours ;

    private List<SectionDto> sections ;
    private List<HomeWorkDto> homeWorks ;


    public CoursDto(){
        super();
    }



    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }

    @Log
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    @Log
    public String getImage(){
        return this.image;
    }
    public void setImage(String image){
        this.image = image;
    }

    @Log
    public Integer getNombreSectionFinalise(){
        return this.nombreSectionFinalise;
    }
    public void setNombreSectionFinalise(Integer nombreSectionFinalise){
        this.nombreSectionFinalise = nombreSectionFinalise;
    }

    @Log
    public Integer getNombreSectionEnCours(){
        return this.nombreSectionEnCours;
    }
    public void setNombreSectionEnCours(Integer nombreSectionEnCours){
        this.nombreSectionEnCours = nombreSectionEnCours;
    }

    @Log
    public Integer getNombreLinkEnCours(){
        return this.nombreLinkEnCours;
    }
    public void setNombreLinkEnCours(Integer nombreLinkEnCours){
        this.nombreLinkEnCours = nombreLinkEnCours;
    }

    @Log
    public Integer getNombreLinkFinalise(){
        return this.nombreLinkFinalise;
    }
    public void setNombreLinkFinalise(Integer nombreLinkFinalise){
        this.nombreLinkFinalise = nombreLinkFinalise;
    }

    @Log
    public Integer getNumeroOrder(){
        return this.numeroOrder;
    }
    public void setNumeroOrder(Integer numeroOrder){
        this.numeroOrder = numeroOrder;
    }


    public EtatCoursDto getEtatCours(){
        return this.etatCours;
    }

    public void setEtatCours(EtatCoursDto etatCours){
        this.etatCours = etatCours;
    }
    public ParcoursDto getParcours(){
        return this.parcours;
    }

    public void setParcours(ParcoursDto parcours){
        this.parcours = parcours;
    }



    public List<SectionDto> getSections(){
        return this.sections;
    }

    public void setSections(List<SectionDto> sections){
        this.sections = sections;
    }
    public List<HomeWorkDto> getHomeWorks(){
        return this.homeWorks;
    }

    public void setHomeWorks(List<HomeWorkDto> homeWorks){
        this.homeWorks = homeWorks;
    }



}
