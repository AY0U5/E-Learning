package  ma.zs.alc.dao.criteria.core.grpe;



import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;

public class GroupeEtudeCriteria extends  BaseCriteria  {

    private String libelle;
    private String libelleLike;
    private String description;
    private String descriptionLike;
    private String nombreEtudiant;
    private String nombreEtudiantMin;
    private String nombreEtudiantMax;



    public GroupeEtudeCriteria(){}

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

    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescriptionLike(){
        return this.descriptionLike;
    }
    public void setDescriptionLike(String descriptionLike){
        this.descriptionLike = descriptionLike;
    }

    public String getNombreEtudiant(){
        return this.nombreEtudiant;
    }
    public void setNombreEtudiant(String nombreEtudiant){
        this.nombreEtudiant = nombreEtudiant;
    }   
    public String getNombreEtudiantMin(){
        return this.nombreEtudiantMin;
    }
    public void setNombreEtudiantMin(String nombreEtudiantMin){
        this.nombreEtudiantMin = nombreEtudiantMin;
    }
    public String getNombreEtudiantMax(){
        return this.nombreEtudiantMax;
    }
    public void setNombreEtudiantMax(String nombreEtudiantMax){
        this.nombreEtudiantMax = nombreEtudiantMax;
    }
      

}
