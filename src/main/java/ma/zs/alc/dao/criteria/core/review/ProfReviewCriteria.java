package  ma.zs.alc.dao.criteria.core.review;


import ma.zs.alc.dao.criteria.core.inscription.EtudiantCriteria;
import ma.zs.alc.dao.criteria.core.course.CoursCriteria;
import ma.zs.alc.dao.criteria.core.prof.ProfCriteria;

import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class ProfReviewCriteria extends  BaseCriteria  {

    private String review;
    private String reviewMin;
    private String reviewMax;
    private String comment;
    private String commentLike;
    private LocalDateTime dateReview;
    private LocalDateTime dateReviewFrom;
    private LocalDateTime dateReviewTo;

    private EtudiantCriteria etudiant ;
    private List<EtudiantCriteria> etudiants ;
    private ProfCriteria prof ;
    private List<ProfCriteria> profs ;
    private CoursCriteria cours ;
    private List<CoursCriteria> courss ;


    public ProfReviewCriteria(){}

    public String getReview(){
        return this.review;
    }
    public void setReview(String review){
        this.review = review;
    }   
    public String getReviewMin(){
        return this.reviewMin;
    }
    public void setReviewMin(String reviewMin){
        this.reviewMin = reviewMin;
    }
    public String getReviewMax(){
        return this.reviewMax;
    }
    public void setReviewMax(String reviewMax){
        this.reviewMax = reviewMax;
    }
      
    public String getComment(){
        return this.comment;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    public String getCommentLike(){
        return this.commentLike;
    }
    public void setCommentLike(String commentLike){
        this.commentLike = commentLike;
    }

    public LocalDateTime getDateReview(){
        return this.dateReview;
    }
    public void setDateReview(LocalDateTime dateReview){
        this.dateReview = dateReview;
    }
    public LocalDateTime getDateReviewFrom(){
        return this.dateReviewFrom;
    }
    public void setDateReviewFrom(LocalDateTime dateReviewFrom){
        this.dateReviewFrom = dateReviewFrom;
    }
    public LocalDateTime getDateReviewTo(){
        return this.dateReviewTo;
    }
    public void setDateReviewTo(LocalDateTime dateReviewTo){
        this.dateReviewTo = dateReviewTo;
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
    public ProfCriteria getProf(){
        return this.prof;
    }

    public void setProf(ProfCriteria prof){
        this.prof = prof;
    }
    public List<ProfCriteria> getProfs(){
        return this.profs;
    }

    public void setProfs(List<ProfCriteria> profs){
        this.profs = profs;
    }
    public CoursCriteria getCours(){
        return this.cours;
    }

    public void setCours(CoursCriteria cours){
        this.cours = cours;
    }
    public List<CoursCriteria> getCourss(){
        return this.courss;
    }

    public void setCourss(List<CoursCriteria> courss){
        this.courss = courss;
    }
}
