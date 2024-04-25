package  ma.zs.alc.ws.dto.courseref;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


import ma.zs.alc.ws.dto.course.SectionDto;
import ma.zs.alc.ws.dto.course.CoursDto;
import ma.zs.alc.ws.dto.course.SectionItemDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategorieSectionDto  extends AuditBaseDto {

    private String code  ;
    private String libelle  ;
    private Integer numeroOrder  = 0 ;

    private SuperCategorieSectionDto superCategorieSection ;

    private List<SectionDto> sections ;


    public CategorieSectionDto(){
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
    public Integer getNumeroOrder(){
        return this.numeroOrder;
    }
    public void setNumeroOrder(Integer numeroOrder){
        this.numeroOrder = numeroOrder;
    }


    public SuperCategorieSectionDto getSuperCategorieSection(){
        return this.superCategorieSection;
    }

    public void setSuperCategorieSection(SuperCategorieSectionDto superCategorieSection){
        this.superCategorieSection = superCategorieSection;
    }



    public List<SectionDto> getSections(){
        return this.sections;
    }

    public void setSections(List<SectionDto> sections){
        this.sections = sections;
    }



}
