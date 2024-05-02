package  ma.zs.alc.ws.dto.course;

import ma.zs.alc.ws.dto.courseref.EtatSectionDto;
import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


import ma.zs.alc.ws.dto.courseref.CategorieSectionDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class SectionDto  extends AuditBaseDto {

    private String code  ;
    private String libelle  ;
    private String urlImage  ;
    private String urlImage2  ;
    private String urlImage3  ;
    private String urlVideo  ;
    private String contenu  ;
    private String questions  ;
    private String indicationProf  ;
    private Integer numeroOrder  = 0 ;
    private Integer url  = 0 ;
    private Integer content  = 0 ;

    private CategorieSectionDto categorieSection ;

    private EtatSectionDto etatSection ;
    private CoursDto cours ;

    private List<SectionItemDto> sectionItems ;


    public SectionDto(){
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
    public String getUrlImage(){
        return this.urlImage;
    }
    public void setUrlImage(String urlImage){
        this.urlImage = urlImage;
    }

    @Log
    public String getUrlImage2(){
        return this.urlImage2;
    }
    public void setUrlImage2(String urlImage2){
        this.urlImage2 = urlImage2;
    }

    @Log
    public String getUrlImage3(){
        return this.urlImage3;
    }
    public void setUrlImage3(String urlImage3){
        this.urlImage3 = urlImage3;
    }

    @Log
    public String getUrlVideo(){
        return this.urlVideo;
    }
    public void setUrlVideo(String urlVideo){
        this.urlVideo = urlVideo;
    }

    @Log
    public String getContenu(){
        return this.contenu;
    }
    public void setContenu(String contenu){
        this.contenu = contenu;
    }

    @Log
    public String getQuestions(){
        return this.questions;
    }
    public void setQuestions(String questions){
        this.questions = questions;
    }

    @Log
    public String getIndicationProf(){
        return this.indicationProf;
    }
    public void setIndicationProf(String indicationProf){
        this.indicationProf = indicationProf;
    }

    @Log
    public Integer getNumeroOrder(){
        return this.numeroOrder;
    }
    public void setNumeroOrder(Integer numeroOrder){
        this.numeroOrder = numeroOrder;
    }

    @Log
    public Integer getUrl(){
        return this.url;
    }
    public void setUrl(Integer url){
        this.url = url;
    }

    @Log
    public Integer getContent(){
        return this.content;
    }
    public void setContent(Integer content){
        this.content = content;
    }


    public CategorieSectionDto getCategorieSection(){
        return this.categorieSection;
    }

    public void setCategorieSection(CategorieSectionDto categorieSection){
        this.categorieSection = categorieSection;
    }

    public EtatSectionDto getEtatSection(){
        return this.etatSection;
    }

    public void setEtatSection(EtatSectionDto etatSection){
        this.etatSection = etatSection;
    }
    public CoursDto getCours(){
        return this.cours;
    }

    public void setCours(CoursDto cours){
        this.cours = cours;
    }



    public List<SectionItemDto> getSectionItems(){
        return this.sectionItems;
    }

    public void setSectionItems(List<SectionItemDto> sectionItems){
        this.sectionItems = sectionItems;
    }



}
