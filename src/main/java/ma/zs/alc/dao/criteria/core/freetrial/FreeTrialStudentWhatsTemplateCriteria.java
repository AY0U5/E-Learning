package  ma.zs.alc.dao.criteria.core.freetrial;



import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;

public class FreeTrialStudentWhatsTemplateCriteria extends  BaseCriteria  {

    private String object;
    private String objectLike;
    private String corps;
    private String corpsLike;
    private String source;
    private String sourceLike;



    public FreeTrialStudentWhatsTemplateCriteria(){}

    public String getObject(){
        return this.object;
    }
    public void setObject(String object){
        this.object = object;
    }
    public String getObjectLike(){
        return this.objectLike;
    }
    public void setObjectLike(String objectLike){
        this.objectLike = objectLike;
    }

    public String getCorps(){
        return this.corps;
    }
    public void setCorps(String corps){
        this.corps = corps;
    }
    public String getCorpsLike(){
        return this.corpsLike;
    }
    public void setCorpsLike(String corpsLike){
        this.corpsLike = corpsLike;
    }

    public String getSource(){
        return this.source;
    }
    public void setSource(String source){
        this.source = source;
    }
    public String getSourceLike(){
        return this.sourceLike;
    }
    public void setSourceLike(String sourceLike){
        this.sourceLike = sourceLike;
    }


}
