package  ma.zs.alc.dao.criteria.core.quiz;



import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ReponseCriteria extends  BaseCriteria  {

    private String ref;
    private String refLike;
    private String lib;
    private String libLike;
    private String etatReponse;
    private String etatReponseLike;
    private String numero;
    private String numeroMin;
    private String numeroMax;

    private QuestionCriteria question ;
    private List<QuestionCriteria> questions ;


    public ReponseCriteria(){}

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

    public String getEtatReponse(){
        return this.etatReponse;
    }
    public void setEtatReponse(String etatReponse){
        this.etatReponse = etatReponse;
    }
    public String getEtatReponseLike(){
        return this.etatReponseLike;
    }
    public void setEtatReponseLike(String etatReponseLike){
        this.etatReponseLike = etatReponseLike;
    }

    public String getNumero(){
        return this.numero;
    }
    public void setNumero(String numero){
        this.numero = numero;
    }   
    public String getNumeroMin(){
        return this.numeroMin;
    }
    public void setNumeroMin(String numeroMin){
        this.numeroMin = numeroMin;
    }
    public String getNumeroMax(){
        return this.numeroMax;
    }
    public void setNumeroMax(String numeroMax){
        this.numeroMax = numeroMax;
    }
      

    public QuestionCriteria getQuestion(){
        return this.question;
    }

    public void setQuestion(QuestionCriteria question){
        this.question = question;
    }
    public List<QuestionCriteria> getQuestions(){
        return this.questions;
    }

    public void setQuestions(List<QuestionCriteria> questions){
        this.questions = questions;
    }
}
