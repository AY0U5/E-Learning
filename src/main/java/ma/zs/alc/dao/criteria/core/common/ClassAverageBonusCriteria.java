package  ma.zs.alc.dao.criteria.core.common;



import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ClassAverageBonusCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String nombreSession;
    private String nombreSessionMin;
    private String nombreSessionMax;
    private String prix;
    private String prixMin;
    private String prixMax;



    public ClassAverageBonusCriteria(){}

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

    public String getNombreSession(){
        return this.nombreSession;
    }
    public void setNombreSession(String nombreSession){
        this.nombreSession = nombreSession;
    }   
    public String getNombreSessionMin(){
        return this.nombreSessionMin;
    }
    public void setNombreSessionMin(String nombreSessionMin){
        this.nombreSessionMin = nombreSessionMin;
    }
    public String getNombreSessionMax(){
        return this.nombreSessionMax;
    }
    public void setNombreSessionMax(String nombreSessionMax){
        this.nombreSessionMax = nombreSessionMax;
    }
      
    public String getPrix(){
        return this.prix;
    }
    public void setPrix(String prix){
        this.prix = prix;
    }   
    public String getPrixMin(){
        return this.prixMin;
    }
    public void setPrixMin(String prixMin){
        this.prixMin = prixMin;
    }
    public String getPrixMax(){
        return this.prixMax;
    }
    public void setPrixMax(String prixMax){
        this.prixMax = prixMax;
    }
      

}
