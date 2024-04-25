package  ma.zs.alc.dao.criteria.core.course;


import ma.zs.alc.dao.criteria.core.courseref.CategorieSectionCriteria;

import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;

public class SectionCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String libelle;
    private String libelleLike;
    private String urlImage;
    private String urlImageLike;
    private String urlImage2;
    private String urlImage2Like;
    private String urlImage3;
    private String urlImage3Like;
    private String urlVideo;
    private String urlVideoLike;
    private String contenu;
    private String contenuLike;
    private String questions;
    private String questionsLike;
    private String indicationProf;
    private String indicationProfLike;
    private String numeroOrder;
    private String numeroOrderMin;
    private String numeroOrderMax;
    private String url;
    private String urlMin;
    private String urlMax;
    private String content;
    private String contentMin;
    private String contentMax;

    private CategorieSectionCriteria categorieSection ;
    private List<CategorieSectionCriteria> categorieSections ;
    private CoursCriteria cours ;
    private List<CoursCriteria> courss ;


    public SectionCriteria(){}

    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCodeLike(){
        return this.codeLike;
    }
    public void setCodeLike(String codeLike){
        this.codeLike = codeLike;
    }

    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getLibelleLike(){
        return this.libelleLike;
    }
    public void setLibelleLike(String libelleLike){
        this.libelleLike = libelleLike;
    }

    public String getUrlImage(){
        return this.urlImage;
    }
    public void setUrlImage(String urlImage){
        this.urlImage = urlImage;
    }
    public String getUrlImageLike(){
        return this.urlImageLike;
    }
    public void setUrlImageLike(String urlImageLike){
        this.urlImageLike = urlImageLike;
    }

    public String getUrlImage2(){
        return this.urlImage2;
    }
    public void setUrlImage2(String urlImage2){
        this.urlImage2 = urlImage2;
    }
    public String getUrlImage2Like(){
        return this.urlImage2Like;
    }
    public void setUrlImage2Like(String urlImage2Like){
        this.urlImage2Like = urlImage2Like;
    }

    public String getUrlImage3(){
        return this.urlImage3;
    }
    public void setUrlImage3(String urlImage3){
        this.urlImage3 = urlImage3;
    }
    public String getUrlImage3Like(){
        return this.urlImage3Like;
    }
    public void setUrlImage3Like(String urlImage3Like){
        this.urlImage3Like = urlImage3Like;
    }

    public String getUrlVideo(){
        return this.urlVideo;
    }
    public void setUrlVideo(String urlVideo){
        this.urlVideo = urlVideo;
    }
    public String getUrlVideoLike(){
        return this.urlVideoLike;
    }
    public void setUrlVideoLike(String urlVideoLike){
        this.urlVideoLike = urlVideoLike;
    }

    public String getContenu(){
        return this.contenu;
    }
    public void setContenu(String contenu){
        this.contenu = contenu;
    }
    public String getContenuLike(){
        return this.contenuLike;
    }
    public void setContenuLike(String contenuLike){
        this.contenuLike = contenuLike;
    }

    public String getQuestions(){
        return this.questions;
    }
    public void setQuestions(String questions){
        this.questions = questions;
    }
    public String getQuestionsLike(){
        return this.questionsLike;
    }
    public void setQuestionsLike(String questionsLike){
        this.questionsLike = questionsLike;
    }

    public String getIndicationProf(){
        return this.indicationProf;
    }
    public void setIndicationProf(String indicationProf){
        this.indicationProf = indicationProf;
    }
    public String getIndicationProfLike(){
        return this.indicationProfLike;
    }
    public void setIndicationProfLike(String indicationProfLike){
        this.indicationProfLike = indicationProfLike;
    }

    public String getNumeroOrder(){
        return this.numeroOrder;
    }
    public void setNumeroOrder(String numeroOrder){
        this.numeroOrder = numeroOrder;
    }   
    public String getNumeroOrderMin(){
        return this.numeroOrderMin;
    }
    public void setNumeroOrderMin(String numeroOrderMin){
        this.numeroOrderMin = numeroOrderMin;
    }
    public String getNumeroOrderMax(){
        return this.numeroOrderMax;
    }
    public void setNumeroOrderMax(String numeroOrderMax){
        this.numeroOrderMax = numeroOrderMax;
    }
      
    public String getUrl(){
        return this.url;
    }
    public void setUrl(String url){
        this.url = url;
    }   
    public String getUrlMin(){
        return this.urlMin;
    }
    public void setUrlMin(String urlMin){
        this.urlMin = urlMin;
    }
    public String getUrlMax(){
        return this.urlMax;
    }
    public void setUrlMax(String urlMax){
        this.urlMax = urlMax;
    }
      
    public String getContent(){
        return this.content;
    }
    public void setContent(String content){
        this.content = content;
    }   
    public String getContentMin(){
        return this.contentMin;
    }
    public void setContentMin(String contentMin){
        this.contentMin = contentMin;
    }
    public String getContentMax(){
        return this.contentMax;
    }
    public void setContentMax(String contentMax){
        this.contentMax = contentMax;
    }
      

    public CategorieSectionCriteria getCategorieSection(){
        return this.categorieSection;
    }

    public void setCategorieSection(CategorieSectionCriteria categorieSection){
        this.categorieSection = categorieSection;
    }
    public List<CategorieSectionCriteria> getCategorieSections(){
        return this.categorieSections;
    }

    public void setCategorieSections(List<CategorieSectionCriteria> categorieSections){
        this.categorieSections = categorieSections;
    }
    public CoursCriteria getCours(){
        return this.cours;
    }

    public void setCours(CoursCriteria cours){
        this.cours = cours;
    }
    public List<CoursCriteria> getCourss(){
        return this.courss;
    }

    public void setCourss(List<CoursCriteria> courss){
        this.courss = courss;
    }
}
