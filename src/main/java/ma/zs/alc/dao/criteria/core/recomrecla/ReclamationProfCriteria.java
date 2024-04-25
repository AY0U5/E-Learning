package  ma.zs.alc.dao.criteria.core.recomrecla;


import ma.zs.alc.dao.criteria.core.alc.AdminCriteria;
import ma.zs.alc.dao.criteria.core.prof.ProfCriteria;

import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class ReclamationProfCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private LocalDateTime dateReclamation;
    private LocalDateTime dateReclamationFrom;
    private LocalDateTime dateReclamationTo;
    private String message;
    private String messageLike;
    private Boolean traite;
    private LocalDateTime dateTraitement;
    private LocalDateTime dateTraitementFrom;
    private LocalDateTime dateTraitementTo;
    private LocalDateTime dateReponse;
    private LocalDateTime dateReponseFrom;
    private LocalDateTime dateReponseTo;
    private Boolean postView;
    private String commentaireTraiteur;
    private String commentaireTraiteurLike;
    private String objetReclamationProf;
    private String objetReclamationProfLike;

    private AdminCriteria admin ;
    private List<AdminCriteria> admins ;
    private ProfCriteria prof ;
    private List<ProfCriteria> profs ;
    private TypeReclamationProfCriteria typeReclamationProf ;
    private List<TypeReclamationProfCriteria> typeReclamationProfs ;


    public ReclamationProfCriteria(){}

    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public String getReferenceLike(){
        return this.referenceLike;
    }
    public void setReferenceLike(String referenceLike){
        this.referenceLike = referenceLike;
    }

    public LocalDateTime getDateReclamation(){
        return this.dateReclamation;
    }
    public void setDateReclamation(LocalDateTime dateReclamation){
        this.dateReclamation = dateReclamation;
    }
    public LocalDateTime getDateReclamationFrom(){
        return this.dateReclamationFrom;
    }
    public void setDateReclamationFrom(LocalDateTime dateReclamationFrom){
        this.dateReclamationFrom = dateReclamationFrom;
    }
    public LocalDateTime getDateReclamationTo(){
        return this.dateReclamationTo;
    }
    public void setDateReclamationTo(LocalDateTime dateReclamationTo){
        this.dateReclamationTo = dateReclamationTo;
    }
    public String getMessage(){
        return this.message;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public String getMessageLike(){
        return this.messageLike;
    }
    public void setMessageLike(String messageLike){
        this.messageLike = messageLike;
    }

    public Boolean getTraite(){
        return this.traite;
    }
    public void setTraite(Boolean traite){
        this.traite = traite;
    }
    public LocalDateTime getDateTraitement(){
        return this.dateTraitement;
    }
    public void setDateTraitement(LocalDateTime dateTraitement){
        this.dateTraitement = dateTraitement;
    }
    public LocalDateTime getDateTraitementFrom(){
        return this.dateTraitementFrom;
    }
    public void setDateTraitementFrom(LocalDateTime dateTraitementFrom){
        this.dateTraitementFrom = dateTraitementFrom;
    }
    public LocalDateTime getDateTraitementTo(){
        return this.dateTraitementTo;
    }
    public void setDateTraitementTo(LocalDateTime dateTraitementTo){
        this.dateTraitementTo = dateTraitementTo;
    }
    public LocalDateTime getDateReponse(){
        return this.dateReponse;
    }
    public void setDateReponse(LocalDateTime dateReponse){
        this.dateReponse = dateReponse;
    }
    public LocalDateTime getDateReponseFrom(){
        return this.dateReponseFrom;
    }
    public void setDateReponseFrom(LocalDateTime dateReponseFrom){
        this.dateReponseFrom = dateReponseFrom;
    }
    public LocalDateTime getDateReponseTo(){
        return this.dateReponseTo;
    }
    public void setDateReponseTo(LocalDateTime dateReponseTo){
        this.dateReponseTo = dateReponseTo;
    }
    public Boolean getPostView(){
        return this.postView;
    }
    public void setPostView(Boolean postView){
        this.postView = postView;
    }
    public String getCommentaireTraiteur(){
        return this.commentaireTraiteur;
    }
    public void setCommentaireTraiteur(String commentaireTraiteur){
        this.commentaireTraiteur = commentaireTraiteur;
    }
    public String getCommentaireTraiteurLike(){
        return this.commentaireTraiteurLike;
    }
    public void setCommentaireTraiteurLike(String commentaireTraiteurLike){
        this.commentaireTraiteurLike = commentaireTraiteurLike;
    }

    public String getObjetReclamationProf(){
        return this.objetReclamationProf;
    }
    public void setObjetReclamationProf(String objetReclamationProf){
        this.objetReclamationProf = objetReclamationProf;
    }
    public String getObjetReclamationProfLike(){
        return this.objetReclamationProfLike;
    }
    public void setObjetReclamationProfLike(String objetReclamationProfLike){
        this.objetReclamationProfLike = objetReclamationProfLike;
    }


    public AdminCriteria getAdmin(){
        return this.admin;
    }

    public void setAdmin(AdminCriteria admin){
        this.admin = admin;
    }
    public List<AdminCriteria> getAdmins(){
        return this.admins;
    }

    public void setAdmins(List<AdminCriteria> admins){
        this.admins = admins;
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
    public TypeReclamationProfCriteria getTypeReclamationProf(){
        return this.typeReclamationProf;
    }

    public void setTypeReclamationProf(TypeReclamationProfCriteria typeReclamationProf){
        this.typeReclamationProf = typeReclamationProf;
    }
    public List<TypeReclamationProfCriteria> getTypeReclamationProfs(){
        return this.typeReclamationProfs;
    }

    public void setTypeReclamationProfs(List<TypeReclamationProfCriteria> typeReclamationProfs){
        this.typeReclamationProfs = typeReclamationProfs;
    }
}
