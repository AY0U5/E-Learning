package  ma.zs.alc.dao.criteria.core.quiz;


import ma.zs.alc.dao.criteria.core.quizref.TypeDeQuestionCriteria;
import ma.zs.alc.dao.criteria.core.homework.HomeWorkCriteria;

import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;

public class QuestionCriteria extends  BaseCriteria  {

    private String ref;
    private String refLike;
    private String libelle;
    private String libelleLike;
    private String urlImg;
    private String urlImgLike;
    private String urlVideo;
    private String urlVideoLike;
    private String numero;
    private String numeroMin;
    private String numeroMax;
    private String pointReponseJuste;
    private String pointReponseJusteMin;
    private String pointReponseJusteMax;
    private String pointReponsefausse;
    private String pointReponsefausseMin;
    private String pointReponsefausseMax;

    private TypeDeQuestionCriteria typeDeQuestion ;
    private List<TypeDeQuestionCriteria> typeDeQuestions ;
    private QuizCriteria quiz ;
    private List<QuizCriteria> quizs ;
    private HomeWorkCriteria homeWork ;
    private List<HomeWorkCriteria> homeWorks ;


    public QuestionCriteria(){}

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

    public String getUrlImg(){
        return this.urlImg;
    }
    public void setUrlImg(String urlImg){
        this.urlImg = urlImg;
    }
    public String getUrlImgLike(){
        return this.urlImgLike;
    }
    public void setUrlImgLike(String urlImgLike){
        this.urlImgLike = urlImgLike;
    }

    public String getUrlVideo(){
        return this.urlVideo;
    }
    public void setUrlVideo(String urlVideo){
        this.urlVideo = urlVideo;
    }
    public String getUrlVideoLike(){
        return this.urlVideoLike;
    }
    public void setUrlVideoLike(String urlVideoLike){
        this.urlVideoLike = urlVideoLike;
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
      
    public String getPointReponseJuste(){
        return this.pointReponseJuste;
    }
    public void setPointReponseJuste(String pointReponseJuste){
        this.pointReponseJuste = pointReponseJuste;
    }   
    public String getPointReponseJusteMin(){
        return this.pointReponseJusteMin;
    }
    public void setPointReponseJusteMin(String pointReponseJusteMin){
        this.pointReponseJusteMin = pointReponseJusteMin;
    }
    public String getPointReponseJusteMax(){
        return this.pointReponseJusteMax;
    }
    public void setPointReponseJusteMax(String pointReponseJusteMax){
        this.pointReponseJusteMax = pointReponseJusteMax;
    }
      
    public String getPointReponsefausse(){
        return this.pointReponsefausse;
    }
    public void setPointReponsefausse(String pointReponsefausse){
        this.pointReponsefausse = pointReponsefausse;
    }   
    public String getPointReponsefausseMin(){
        return this.pointReponsefausseMin;
    }
    public void setPointReponsefausseMin(String pointReponsefausseMin){
        this.pointReponsefausseMin = pointReponsefausseMin;
    }
    public String getPointReponsefausseMax(){
        return this.pointReponsefausseMax;
    }
    public void setPointReponsefausseMax(String pointReponsefausseMax){
        this.pointReponsefausseMax = pointReponsefausseMax;
    }
      

    public TypeDeQuestionCriteria getTypeDeQuestion(){
        return this.typeDeQuestion;
    }

    public void setTypeDeQuestion(TypeDeQuestionCriteria typeDeQuestion){
        this.typeDeQuestion = typeDeQuestion;
    }
    public List<TypeDeQuestionCriteria> getTypeDeQuestions(){
        return this.typeDeQuestions;
    }

    public void setTypeDeQuestions(List<TypeDeQuestionCriteria> typeDeQuestions){
        this.typeDeQuestions = typeDeQuestions;
    }
    public QuizCriteria getQuiz(){
        return this.quiz;
    }

    public void setQuiz(QuizCriteria quiz){
        this.quiz = quiz;
    }
    public List<QuizCriteria> getQuizs(){
        return this.quizs;
    }

    public void setQuizs(List<QuizCriteria> quizs){
        this.quizs = quizs;
    }
    public HomeWorkCriteria getHomeWork(){
        return this.homeWork;
    }

    public void setHomeWork(HomeWorkCriteria homeWork){
        this.homeWork = homeWork;
    }
    public List<HomeWorkCriteria> getHomeWorks(){
        return this.homeWorks;
    }

    public void setHomeWorks(List<HomeWorkCriteria> homeWorks){
        this.homeWorks = homeWorks;
    }
}
