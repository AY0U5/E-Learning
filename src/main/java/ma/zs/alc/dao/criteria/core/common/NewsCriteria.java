package  ma.zs.alc.dao.criteria.core.common;



import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class NewsCriteria extends  BaseCriteria  {

    private String ref;
    private String refLike;
    private String libelle;
    private String libelleLike;
    private String image;
    private String imageLike;
    private String description;
    private String descriptionLike;
    private LocalDateTime dateNews;
    private LocalDateTime dateNewsFrom;
    private LocalDateTime dateNewsTo;
    private LocalDateTime dateDebut;
    private LocalDateTime dateDebutFrom;
    private LocalDateTime dateDebutTo;
    private LocalDateTime dateFin;
    private LocalDateTime dateFinFrom;
    private LocalDateTime dateFinTo;
    private String numeroOrdre;
    private String numeroOrdreMin;
    private String numeroOrdreMax;
    private String destinataire;
    private String destinataireLike;



    public NewsCriteria(){}

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

    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescriptionLike(){
        return this.descriptionLike;
    }
    public void setDescriptionLike(String descriptionLike){
        this.descriptionLike = descriptionLike;
    }

    public LocalDateTime getDateNews(){
        return this.dateNews;
    }
    public void setDateNews(LocalDateTime dateNews){
        this.dateNews = dateNews;
    }
    public LocalDateTime getDateNewsFrom(){
        return this.dateNewsFrom;
    }
    public void setDateNewsFrom(LocalDateTime dateNewsFrom){
        this.dateNewsFrom = dateNewsFrom;
    }
    public LocalDateTime getDateNewsTo(){
        return this.dateNewsTo;
    }
    public void setDateNewsTo(LocalDateTime dateNewsTo){
        this.dateNewsTo = dateNewsTo;
    }
    public LocalDateTime getDateDebut(){
        return this.dateDebut;
    }
    public void setDateDebut(LocalDateTime dateDebut){
        this.dateDebut = dateDebut;
    }
    public LocalDateTime getDateDebutFrom(){
        return this.dateDebutFrom;
    }
    public void setDateDebutFrom(LocalDateTime dateDebutFrom){
        this.dateDebutFrom = dateDebutFrom;
    }
    public LocalDateTime getDateDebutTo(){
        return this.dateDebutTo;
    }
    public void setDateDebutTo(LocalDateTime dateDebutTo){
        this.dateDebutTo = dateDebutTo;
    }
    public LocalDateTime getDateFin(){
        return this.dateFin;
    }
    public void setDateFin(LocalDateTime dateFin){
        this.dateFin = dateFin;
    }
    public LocalDateTime getDateFinFrom(){
        return this.dateFinFrom;
    }
    public void setDateFinFrom(LocalDateTime dateFinFrom){
        this.dateFinFrom = dateFinFrom;
    }
    public LocalDateTime getDateFinTo(){
        return this.dateFinTo;
    }
    public void setDateFinTo(LocalDateTime dateFinTo){
        this.dateFinTo = dateFinTo;
    }
    public String getNumeroOrdre(){
        return this.numeroOrdre;
    }
    public void setNumeroOrdre(String numeroOrdre){
        this.numeroOrdre = numeroOrdre;
    }   
    public String getNumeroOrdreMin(){
        return this.numeroOrdreMin;
    }
    public void setNumeroOrdreMin(String numeroOrdreMin){
        this.numeroOrdreMin = numeroOrdreMin;
    }
    public String getNumeroOrdreMax(){
        return this.numeroOrdreMax;
    }
    public void setNumeroOrdreMax(String numeroOrdreMax){
        this.numeroOrdreMax = numeroOrdreMax;
    }
      
    public String getDestinataire(){
        return this.destinataire;
    }
    public void setDestinataire(String destinataire){
        this.destinataire = destinataire;
    }
    public String getDestinataireLike(){
        return this.destinataireLike;
    }
    public void setDestinataireLike(String destinataireLike){
        this.destinataireLike = destinataireLike;
    }


}
