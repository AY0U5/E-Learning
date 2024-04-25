package  ma.zs.alc.dao.criteria.core.homework;



import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;

public class TypeHomeWorkCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String lib;
    private String libLike;



    public TypeHomeWorkCriteria(){}

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
