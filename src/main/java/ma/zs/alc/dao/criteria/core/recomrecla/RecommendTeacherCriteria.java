package  ma.zs.alc.dao.criteria.core.recomrecla;


import ma.zs.alc.dao.criteria.core.prof.ProfCriteria;

import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class RecommendTeacherCriteria extends  BaseCriteria  {

    private String ref;
    private String refLike;
    private String nombrevote;
    private String nombrevoteMin;
    private String nombrevoteMax;
    private String nom;
    private String nomLike;
    private String prenom;
    private String prenomLike;
    private String commentaire;
    private String commentaireLike;
    private String telephone;
    private String telephoneLike;
    private String login;
    private String loginLike;
    private LocalDateTime dateRecommamdation;
    private LocalDateTime dateRecommamdationFrom;
    private LocalDateTime dateRecommamdationTo;

    private ProfCriteria prof ;
    private List<ProfCriteria> profs ;


    public RecommendTeacherCriteria(){}

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

    public String getNombrevote(){
        return this.nombrevote;
    }
    public void setNombrevote(String nombrevote){
        this.nombrevote = nombrevote;
    }   
    public String getNombrevoteMin(){
        return this.nombrevoteMin;
    }
    public void setNombrevoteMin(String nombrevoteMin){
        this.nombrevoteMin = nombrevoteMin;
    }
    public String getNombrevoteMax(){
        return this.nombrevoteMax;
    }
    public void setNombrevoteMax(String nombrevoteMax){
        this.nombrevoteMax = nombrevoteMax;
    }
      
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getNomLike(){
        return this.nomLike;
    }
    public void setNomLike(String nomLike){
        this.nomLike = nomLike;
    }

    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public String getPrenomLike(){
        return this.prenomLike;
    }
    public void setPrenomLike(String prenomLike){
        this.prenomLike = prenomLike;
    }

    public String getCommentaire(){
        return this.commentaire;
    }
    public void setCommentaire(String commentaire){
        this.commentaire = commentaire;
    }
    public String getCommentaireLike(){
        return this.commentaireLike;
    }
    public void setCommentaireLike(String commentaireLike){
        this.commentaireLike = commentaireLike;
    }

    public String getTelephone(){
        return this.telephone;
    }
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }
    public String getTelephoneLike(){
        return this.telephoneLike;
    }
    public void setTelephoneLike(String telephoneLike){
        this.telephoneLike = telephoneLike;
    }

    public String getLogin(){
        return this.login;
    }
    public void setLogin(String login){
        this.login = login;
    }
    public String getLoginLike(){
        return this.loginLike;
    }
    public void setLoginLike(String loginLike){
        this.loginLike = loginLike;
    }

    public LocalDateTime getDateRecommamdation(){
        return this.dateRecommamdation;
    }
    public void setDateRecommamdation(LocalDateTime dateRecommamdation){
        this.dateRecommamdation = dateRecommamdation;
    }
    public LocalDateTime getDateRecommamdationFrom(){
        return this.dateRecommamdationFrom;
    }
    public void setDateRecommamdationFrom(LocalDateTime dateRecommamdationFrom){
        this.dateRecommamdationFrom = dateRecommamdationFrom;
    }
    public LocalDateTime getDateRecommamdationTo(){
        return this.dateRecommamdationTo;
    }
    public void setDateRecommamdationTo(LocalDateTime dateRecommamdationTo){
        this.dateRecommamdationTo = dateRecommamdationTo;
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
}
