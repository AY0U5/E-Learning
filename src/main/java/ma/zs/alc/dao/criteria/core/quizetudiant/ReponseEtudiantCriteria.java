package  ma.zs.alc.dao.criteria.core.quizetudiant;


import ma.zs.alc.dao.criteria.core.quiz.QuestionCriteria;
import ma.zs.alc.dao.criteria.core.quiz.ReponseCriteria;

import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ReponseEtudiantCriteria extends  BaseCriteria  {

    private String ref;
    private String refLike;
    private String answer;
    private String answerLike;
    private String note;
    private String noteMin;
    private String noteMax;

    private ReponseCriteria reponse ;
    private List<ReponseCriteria> reponses ;
    private QuizEtudiantCriteria quizEtudiant ;
    private List<QuizEtudiantCriteria> quizEtudiants ;
    private QuestionCriteria question ;
    private List<QuestionCriteria> questions ;


    public ReponseEtudiantCriteria(){}

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

    public String getAnswer(){
        return this.answer;
    }
    public void setAnswer(String answer){
        this.answer = answer;
    }
    public String getAnswerLike(){
        return this.answerLike;
    }
    public void setAnswerLike(String answerLike){
        this.answerLike = answerLike;
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
      

    public ReponseCriteria getReponse(){
        return this.reponse;
    }

    public void setReponse(ReponseCriteria reponse){
        this.reponse = reponse;
    }
    public List<ReponseCriteria> getReponses(){
        return this.reponses;
    }

    public void setReponses(List<ReponseCriteria> reponses){
        this.reponses = reponses;
    }
    public QuizEtudiantCriteria getQuizEtudiant(){
        return this.quizEtudiant;
    }

    public void setQuizEtudiant(QuizEtudiantCriteria quizEtudiant){
        this.quizEtudiant = quizEtudiant;
    }
    public List<QuizEtudiantCriteria> getQuizEtudiants(){
        return this.quizEtudiants;
    }

    public void setQuizEtudiants(List<QuizEtudiantCriteria> quizEtudiants){
        this.quizEtudiants = quizEtudiants;
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
