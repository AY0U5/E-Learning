package  ma.zs.alc.dao.criteria.core.quizetudiant;


import ma.zs.alc.dao.criteria.core.quiz.QuizCriteria;
import ma.zs.alc.dao.criteria.core.inscription.EtudiantCriteria;

import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;

public class QuizEtudiantCriteria extends  BaseCriteria  {

    private String ref;
    private String refLike;
    private String note;
    private String noteMin;
    private String noteMax;
    private String resultat;
    private String resultatLike;
    private String questionCurrent;
    private String questionCurrentMin;
    private String questionCurrentMax;

    private EtudiantCriteria etudiant ;
    private List<EtudiantCriteria> etudiants ;
    private QuizCriteria quiz ;
    private List<QuizCriteria> quizs ;


    public QuizEtudiantCriteria(){}

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

    public String getNote(){
        return this.note;
    }
    public void setNote(String note){
        this.note = note;
    }   
    public String getNoteMin(){
        return this.noteMin;
    }
    public void setNoteMin(String noteMin){
        this.noteMin = noteMin;
    }
    public String getNoteMax(){
        return this.noteMax;
    }
    public void setNoteMax(String noteMax){
        this.noteMax = noteMax;
    }
      
    public String getResultat(){
        return this.resultat;
    }
    public void setResultat(String resultat){
        this.resultat = resultat;
    }
    public String getResultatLike(){
        return this.resultatLike;
    }
    public void setResultatLike(String resultatLike){
        this.resultatLike = resultatLike;
    }

    public String getQuestionCurrent(){
        return this.questionCurrent;
    }
    public void setQuestionCurrent(String questionCurrent){
        this.questionCurrent = questionCurrent;
    }   
    public String getQuestionCurrentMin(){
        return this.questionCurrentMin;
    }
    public void setQuestionCurrentMin(String questionCurrentMin){
        this.questionCurrentMin = questionCurrentMin;
    }
    public String getQuestionCurrentMax(){
        return this.questionCurrentMax;
    }
    public void setQuestionCurrentMax(String questionCurrentMax){
        this.questionCurrentMax = questionCurrentMax;
    }
      

    public EtudiantCriteria getEtudiant(){
        return this.etudiant;
    }

    public void setEtudiant(EtudiantCriteria etudiant){
        this.etudiant = etudiant;
    }
    public List<EtudiantCriteria> getEtudiants(){
        return this.etudiants;
    }

    public void setEtudiants(List<EtudiantCriteria> etudiants){
        this.etudiants = etudiants;
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
}
