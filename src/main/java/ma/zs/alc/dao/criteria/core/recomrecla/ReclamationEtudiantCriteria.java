package  ma.zs.alc.dao.criteria.core.recomrecla;



import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class ReclamationEtudiantCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private LocalDateTime dateReclamation;
    private LocalDateTime dateReclamationFrom;
    private LocalDateTime dateReclamationTo;
    private String message;
    private String messageLike;
    private String setFrom;
    private String setFromLike;
    private String img;
    private String imgLike;
    private Boolean traite;
    private LocalDateTime dateTraitement;
    private LocalDateTime dateTraitementFrom;
    private LocalDateTime dateTraitementTo;
    private LocalDateTime dateReponse;
    private LocalDateTime dateReponseFrom;
    private LocalDateTime dateReponseTo;
    private Boolean postView;
    private String objetReclamationEtudiant;
    private String objetReclamationEtudiantLike;
    private String commentaireTraiteur;
    private String commentaireTraiteurLike;
    private String username;
    private String usernameLike;

    private TypeReclamationEtudiantCriteria typeReclamationEtudiant ;
    private List<TypeReclamationEtudiantCriteria> typeReclamationEtudiants ;


    public ReclamationEtudiantCriteria(){}

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

    public String getSetFrom(){
        return this.setFrom;
    }
    public void setSetFrom(String setFrom){
        this.setFrom = setFrom;
    }
    public String getSetFromLike(){
        return this.setFromLike;
    }
    public void setSetFromLike(String setFromLike){
        this.setFromLike = setFromLike;
    }

    public String getImg(){
        return this.img;
    }
    public void setImg(String img){
        this.img = img;
    }
    public String getImgLike(){
        return this.imgLike;
    }
    public void setImgLike(String imgLike){
        this.imgLike = imgLike;
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
    public String getObjetReclamationEtudiant(){
        return this.objetReclamationEtudiant;
    }
    public void setObjetReclamationEtudiant(String objetReclamationEtudiant){
        this.objetReclamationEtudiant = objetReclamationEtudiant;
    }
    public String getObjetReclamationEtudiantLike(){
        return this.objetReclamationEtudiantLike;
    }
    public void setObjetReclamationEtudiantLike(String objetReclamationEtudiantLike){
        this.objetReclamationEtudiantLike = objetReclamationEtudiantLike;
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

    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsernameLike(){
        return this.usernameLike;
    }
    public void setUsernameLike(String usernameLike){
        this.usernameLike = usernameLike;
    }


    public TypeReclamationEtudiantCriteria getTypeReclamationEtudiant(){
        return this.typeReclamationEtudiant;
    }

    public void setTypeReclamationEtudiant(TypeReclamationEtudiantCriteria typeReclamationEtudiant){
        this.typeReclamationEtudiant = typeReclamationEtudiant;
    }
    public List<TypeReclamationEtudiantCriteria> getTypeReclamationEtudiants(){
        return this.typeReclamationEtudiants;
    }

    public void setTypeReclamationEtudiants(List<TypeReclamationEtudiantCriteria> typeReclamationEtudiants){
        this.typeReclamationEtudiants = typeReclamationEtudiants;
    }
}
