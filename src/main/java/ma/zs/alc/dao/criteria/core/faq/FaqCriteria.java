package  ma.zs.alc.dao.criteria.core.faq;



import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;

public class FaqCriteria extends  BaseCriteria  {

    private String description;
    private String descriptionLike;
    private String libelle;
    private String libelleLike;

    private FaqTypeCriteria faqType ;
    private List<FaqTypeCriteria> faqTypes ;


    public FaqCriteria(){}

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


    public FaqTypeCriteria getFaqType(){
        return this.faqType;
    }

    public void setFaqType(FaqTypeCriteria faqType){
        this.faqType = faqType;
    }
    public List<FaqTypeCriteria> getFaqTypes(){
        return this.faqTypes;
    }

    public void setFaqTypes(List<FaqTypeCriteria> faqTypes){
        this.faqTypes = faqTypes;
    }
}
