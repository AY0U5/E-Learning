package  ma.zs.alc.dao.criteria.core.faq;



import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;

public class FaqTypeCriteria extends  BaseCriteria  {

    private String destinataire;
    private String destinataireLike;
    private String libelle;
    private String libelleLike;



    public FaqTypeCriteria(){}

    public String getDestinataire(){
        return this.destinataire;
    }
    public void setDestinataire(String destinataire){
        this.destinataire = destinataire;
    }
    public String getDestinataireLike(){
        return this.destinataireLike;
    }
    public void setDestinataireLike(String destinataireLike){
        this.destinataireLike = destinataireLike;
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


}
