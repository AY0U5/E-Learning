package  ma.zs.alc.dao.criteria.core.homework;



import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ReponseEtudiantHomeWorkCriteria extends  BaseCriteria  {

    private String answer;
    private String answerLike;
    private String profNote;
    private String profNoteLike;
    private String note;
    private String noteMin;
    private String noteMax;

    private HoweWorkQSTReponseCriteria howeWorkQSTReponse ;
    private List<HoweWorkQSTReponseCriteria> howeWorkQSTReponses ;
    private HomeWorkEtudiantCriteria homeWorkEtudiant ;
    private List<HomeWorkEtudiantCriteria> homeWorkEtudiants ;
    private HomeWorkQuestionCriteria homeWorkQuestion ;
    private List<HomeWorkQuestionCriteria> homeWorkQuestions ;


    public ReponseEtudiantHomeWorkCriteria(){}

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

    public String getProfNote(){
        return this.profNote;
    }
    public void setProfNote(String profNote){
        this.profNote = profNote;
    }
    public String getProfNoteLike(){
        return this.profNoteLike;
    }
    public void setProfNoteLike(String profNoteLike){
        this.profNoteLike = profNoteLike;
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
      

    public HoweWorkQSTReponseCriteria getHoweWorkQSTReponse(){
        return this.howeWorkQSTReponse;
    }

    public void setHoweWorkQSTReponse(HoweWorkQSTReponseCriteria howeWorkQSTReponse){
        this.howeWorkQSTReponse = howeWorkQSTReponse;
    }
    public List<HoweWorkQSTReponseCriteria> getHoweWorkQSTReponses(){
        return this.howeWorkQSTReponses;
    }

    public void setHoweWorkQSTReponses(List<HoweWorkQSTReponseCriteria> howeWorkQSTReponses){
        this.howeWorkQSTReponses = howeWorkQSTReponses;
    }
    public HomeWorkEtudiantCriteria getHomeWorkEtudiant(){
        return this.homeWorkEtudiant;
    }

    public void setHomeWorkEtudiant(HomeWorkEtudiantCriteria homeWorkEtudiant){
        this.homeWorkEtudiant = homeWorkEtudiant;
    }
    public List<HomeWorkEtudiantCriteria> getHomeWorkEtudiants(){
        return this.homeWorkEtudiants;
    }

    public void setHomeWorkEtudiants(List<HomeWorkEtudiantCriteria> homeWorkEtudiants){
        this.homeWorkEtudiants = homeWorkEtudiants;
    }
    public HomeWorkQuestionCriteria getHomeWorkQuestion(){
        return this.homeWorkQuestion;
    }

    public void setHomeWorkQuestion(HomeWorkQuestionCriteria homeWorkQuestion){
        this.homeWorkQuestion = homeWorkQuestion;
    }
    public List<HomeWorkQuestionCriteria> getHomeWorkQuestions(){
        return this.homeWorkQuestions;
    }

    public void setHomeWorkQuestions(List<HomeWorkQuestionCriteria> homeWorkQuestions){
        this.homeWorkQuestions = homeWorkQuestions;
    }
}
