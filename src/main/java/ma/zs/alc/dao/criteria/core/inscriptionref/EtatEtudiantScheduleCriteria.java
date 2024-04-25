package  ma.zs.alc.dao.criteria.core.inscriptionref;



import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;

public class EtatEtudiantScheduleCriteria extends  BaseCriteria  {

    private String ref;
    private String refLike;
    private String libelle;
    private String libelleLike;
    private String couleur;
    private String couleurLike;



    public EtatEtudiantScheduleCriteria(){}

    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }
    public String getRefLike(){
        return this.refLike;
    }
    public void setRefLike(String refLike){
        this.refLike = refLike;
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

    public String getCouleur(){
        return this.couleur;
    }
    public void setCouleur(String couleur){
        this.couleur = couleur;
    }
    public String getCouleurLike(){
        return this.couleurLike;
    }
    public void setCouleurLike(String couleurLike){
        this.couleurLike = couleurLike;
    }


}
