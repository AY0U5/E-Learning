package  ma.zs.alc.dao.criteria.core.courseref;



import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;

public class CategorieSectionCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String libelle;
    private String libelleLike;
    private String numeroOrder;
    private String numeroOrderMin;
    private String numeroOrderMax;

    private SuperCategorieSectionCriteria superCategorieSection ;
    private List<SuperCategorieSectionCriteria> superCategorieSections ;


    public CategorieSectionCriteria(){}

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
      

    public SuperCategorieSectionCriteria getSuperCategorieSection(){
        return this.superCategorieSection;
    }

    public void setSuperCategorieSection(SuperCategorieSectionCriteria superCategorieSection){
        this.superCategorieSection = superCategorieSection;
    }
    public List<SuperCategorieSectionCriteria> getSuperCategorieSections(){
        return this.superCategorieSections;
    }

    public void setSuperCategorieSections(List<SuperCategorieSectionCriteria> superCategorieSections){
        this.superCategorieSections = superCategorieSections;
    }
}
