package  ma.zs.alc.dao.criteria.core.homework;


import ma.zs.alc.dao.criteria.core.course.CoursCriteria;

import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;

public class HomeWorkCriteria extends  BaseCriteria  {

    private String libelle;
    private String libelleLike;
    private String urlImage;
    private String urlImageLike;
    private String urlVideo;
    private String urlVideoLike;

    private CoursCriteria cours ;
    private List<CoursCriteria> courss ;
    private TypeHomeWorkCriteria typeHomeWork ;
    private List<TypeHomeWorkCriteria> typeHomeWorks ;


    public HomeWorkCriteria(){}

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
    public TypeHomeWorkCriteria getTypeHomeWork(){
        return this.typeHomeWork;
    }

    public void setTypeHomeWork(TypeHomeWorkCriteria typeHomeWork){
        this.typeHomeWork = typeHomeWork;
    }
    public List<TypeHomeWorkCriteria> getTypeHomeWorks(){
        return this.typeHomeWorks;
    }

    public void setTypeHomeWorks(List<TypeHomeWorkCriteria> typeHomeWorks){
        this.typeHomeWorks = typeHomeWorks;
    }
}
