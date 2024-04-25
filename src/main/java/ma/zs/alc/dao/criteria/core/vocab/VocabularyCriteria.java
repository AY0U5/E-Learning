package  ma.zs.alc.dao.criteria.core.vocab;


import ma.zs.alc.dao.criteria.core.course.SectionCriteria;

import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;

public class VocabularyCriteria extends  BaseCriteria  {

    private String ref;
    private String refLike;
    private String numero;
    private String numeroMin;
    private String numeroMax;
    private String word;
    private String wordLike;
    private String libelle;
    private String libelleLike;
    private String result;
    private String resultLike;
    private String explication;
    private String explicationLike;
    private String exemple;
    private String exempleLike;
    private String image;
    private String imageLike;

    private SectionCriteria section ;
    private List<SectionCriteria> sections ;
    private VocabularyQuizCriteria vocabularyQuiz ;
    private List<VocabularyQuizCriteria> vocabularyQuizs ;


    public VocabularyCriteria(){}

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
      
    public String getWord(){
        return this.word;
    }
    public void setWord(String word){
        this.word = word;
    }
    public String getWordLike(){
        return this.wordLike;
    }
    public void setWordLike(String wordLike){
        this.wordLike = wordLike;
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

    public String getResult(){
        return this.result;
    }
    public void setResult(String result){
        this.result = result;
    }
    public String getResultLike(){
        return this.resultLike;
    }
    public void setResultLike(String resultLike){
        this.resultLike = resultLike;
    }

    public String getExplication(){
        return this.explication;
    }
    public void setExplication(String explication){
        this.explication = explication;
    }
    public String getExplicationLike(){
        return this.explicationLike;
    }
    public void setExplicationLike(String explicationLike){
        this.explicationLike = explicationLike;
    }

    public String getExemple(){
        return this.exemple;
    }
    public void setExemple(String exemple){
        this.exemple = exemple;
    }
    public String getExempleLike(){
        return this.exempleLike;
    }
    public void setExempleLike(String exempleLike){
        this.exempleLike = exempleLike;
    }

    public String getImage(){
        return this.image;
    }
    public void setImage(String image){
        this.image = image;
    }
    public String getImageLike(){
        return this.imageLike;
    }
    public void setImageLike(String imageLike){
        this.imageLike = imageLike;
    }


    public SectionCriteria getSection(){
        return this.section;
    }

    public void setSection(SectionCriteria section){
        this.section = section;
    }
    public List<SectionCriteria> getSections(){
        return this.sections;
    }

    public void setSections(List<SectionCriteria> sections){
        this.sections = sections;
    }
    public VocabularyQuizCriteria getVocabularyQuiz(){
        return this.vocabularyQuiz;
    }

    public void setVocabularyQuiz(VocabularyQuizCriteria vocabularyQuiz){
        this.vocabularyQuiz = vocabularyQuiz;
    }
    public List<VocabularyQuizCriteria> getVocabularyQuizs(){
        return this.vocabularyQuizs;
    }

    public void setVocabularyQuizs(List<VocabularyQuizCriteria> vocabularyQuizs){
        this.vocabularyQuizs = vocabularyQuizs;
    }
}
