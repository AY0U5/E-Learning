package  ma.zs.alc.dao.criteria.core.prof;



import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;

public class CategorieProfCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String level;
    private String levelLike;
    private String lessonRate;
    private String lessonRateMin;
    private String lessonRateMax;



    public CategorieProfCriteria(){}

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

    public String getLevel(){
        return this.level;
    }
    public void setLevel(String level){
        this.level = level;
    }
    public String getLevelLike(){
        return this.levelLike;
    }
    public void setLevelLike(String levelLike){
        this.levelLike = levelLike;
    }

    public String getLessonRate(){
        return this.lessonRate;
    }
    public void setLessonRate(String lessonRate){
        this.lessonRate = lessonRate;
    }   
    public String getLessonRateMin(){
        return this.lessonRateMin;
    }
    public void setLessonRateMin(String lessonRateMin){
        this.lessonRateMin = lessonRateMin;
    }
    public String getLessonRateMax(){
        return this.lessonRateMax;
    }
    public void setLessonRateMax(String lessonRateMax){
        this.lessonRateMax = lessonRateMax;
    }
      

}
