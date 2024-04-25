package  ma.zs.alc.dao.criteria.core.quizref;



import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;

public class TypeDeQuestionCriteria extends  BaseCriteria  {

    private String ref;
    private String refLike;
    private String lib;
    private String libLike;



    public TypeDeQuestionCriteria(){}

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

    public String getLib(){
        return this.lib;
    }
    public void setLib(String lib){
        this.lib = lib;
    }
    public String getLibLike(){
        return this.libLike;
    }
    public void setLibLike(String libLike){
        this.libLike = libLike;
    }


}
